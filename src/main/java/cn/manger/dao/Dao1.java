package cn.manger.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.manger.model.Trole;

public class Dao1 extends HibernateDaoSupport {

	public void save(Object obj) {
		getHibernateTemplate().save(obj);
	}

	public void saveorupdate(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
		
	}

	public void delete(Object object) {
		getHibernateTemplate().delete(object);
		getHibernateTemplate().flush();
	}

	public void delete(Class<?> clazz, int id) {
		Object object = getHibernateTemplate().get(clazz, id);
		getHibernateTemplate().delete(object);
		
	}

	public void delete(Class<?> clazz, List<Integer> idList) {
		if (idList == null || idList.isEmpty()) {
			return;
		}
		String ids = idList.toString().replace("[", "(").replace("]", ")");
		final String hql = "delete from " + clazz.getName()
				+ " as entity where entity.id in " + ids;
		this.getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				return query.executeUpdate();
			}
		});

	}

	public Object find(Class<?> clazz, int id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public Object findObject(final Class<Trole> clazz) {
		return (List<?>) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from " + clazz.getName();
						Query query = session.createQuery(hql);
						return query.list();
					}

				});
	}

	public void update(Class<?> clazz, String pro, String value, int id) {
		final String str = "update " + clazz.getName() + " obj set obj." + pro
				+ "=" + value + " where obj.id" + "=" + id;
		HibernateTemplate template = getHibernateTemplate();
		template.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query createQuery = session.createQuery(str);
				int executeUpdate = createQuery.executeUpdate();
				return executeUpdate;
			}
		});
	}

	public Object find(Class<?> clazz, String pro, String value) {
		final String str = "from " + clazz.getName() + " obj where obj." + pro
				+ "='" + value + "'";
		Object object = getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query createQuery = session.createQuery(str);
						return createQuery.uniqueResult();
					}
				});
		return object;
	}

	public List<?> findList(final String sql) {
		HibernateTemplate hibernateTemplate2 = getHibernateTemplate();
		List<?> list = hibernateTemplate2
				.execute(new HibernateCallback<List<?>>() {

					@Override
					public List<?> doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query createQuery = session.createQuery(sql);
						List<?> list = createQuery.list();
						return list;
					}
				});
		return list;
	}

	public Object findObject(final String sql) {
		HibernateTemplate hibernateTemplate2 = getHibernateTemplate();
		Object execute = hibernateTemplate2
				.execute(new HibernateCallback<Object>() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query createQuery = session.createQuery(sql);
						Object object = createQuery.uniqueResult();
						return object;
					}
				});
		return execute;
	}
}
