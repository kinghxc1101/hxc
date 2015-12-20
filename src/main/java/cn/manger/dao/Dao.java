package cn.manger.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class Dao extends HibernateDaoSupport {

	public void saveOrUpdate(Object object) {
		getHibernateTemplate().saveOrUpdate(object);
		this.getHibernateTemplate().flush();
	}

	public void save(Object obj) {
		getHibernateTemplate().save(obj);
	}

	public void delete(Class<?> clazz, int id) {
		Object object = this.getHibernateTemplate().get(clazz, id);
		getHibernateTemplate().delete(object);
		this.getHibernateTemplate().flush();
	}

	public void delete(Object entity) {
		this.getHibernateTemplate().delete(entity);
		this.getHibernateTemplate().flush();
	}

	public Object find(Class<?> clazz, int id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public Object find(Class<?> clazz, String property, String value) {
		final String hql = "FROM " + clazz.getName() + " obj WHERE obj."
				+ property + "='" + value + "'";

		Object object = getHibernateTemplate().execute(
				new HibernateCallback<Object>() {

					public Object doInHibernate(Session session) {
						Query query = session.createQuery(hql);
						return query.uniqueResult();
					}

				});
		return object;
	}

	public Object findObject(final String hql) {
		// execute
		HibernateTemplate template = getHibernateTemplate();
		Object object = template.execute(new HibernateCallback<Object>() {
			// connection
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// Transaction transaction = session.beginTransaction();
				Query query = session.createQuery(hql);
				Object obj = query.uniqueResult();
				// session.getTransaction().commit();
				// session.close();
				return obj;
			}
		});
		return object;
	}

	public List<?> findList(final String hql) {
		// execute
		HibernateTemplate template = getHibernateTemplate();

		return (List<?>) template.execute(new HibernateCallback<List<?>>() {

			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// Transaction transaction = session.beginTransaction();
				Query query = session.createQuery(hql);
				List<?> list = query.list();
				// session.getTransaction().commit();
				// session.close();
				return list;
			}
		});
	}

	// sql: update user set name='wuxx'
	// hql: Update cn.believeus.model.Tuser user set user.name="wuxx"
	public void update(Class<?> clazz, int id, String property, Object value) {
		/*
		 * StringBuilder sb=new StringBuilder();
		 * sb.append("Update ").append(clazz
		 * .getName()+" obj ").append("set obj.");
		 * sb.append(property+"=").append(value);
		 */
		final String hql = "Update " + clazz.getName() + " obj set obj."
				+ property + "='" + value + "' where obj.id=" + id;
		System.out.println(hql);
		HibernateTemplate template = getHibernateTemplate();
		template.execute(new HibernateCallback<Object>() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				int result = query.executeUpdate();
				return result;
			}

		});

	}

	public Object findObject(final Class<?> clazz) {
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

	public List<?> findObjectList(final Class<?> clazz, Integer num) {
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
}
