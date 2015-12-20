package cn.manger.service;

import java.util.List;

import javax.annotation.Resource;

import cn.manger.dao.Dao;
import cn.manger.model.Trole;

@org.springframework.stereotype.Service
public class Service {
	@Resource
	private Dao dao;

	public Object find(Class<?> clazz, String pro, String value) {
		return dao.find(clazz, pro, value);
	}

	public void delete(Class<?> clazz, List<Integer> idList) {
		dao.delete(clazz, idList);
	}

	public void save(Object obj) {
		dao.save(obj);
	}

	public Object findObject(final Class<?> clazz) {
		return dao.findObject(clazz);
	}

	public void saveorupdate(Object object) {
		dao.saveOrUpdate(object);
	}

	public void delete(Object object) {
		dao.delete(object);
	}

	public void delete(Class<?> clazz, Integer id) {
		dao.delete(clazz, id);
	}

	public Object find(Class<?> clazz, int id) {
		return dao.find(clazz, id);
	}

//	public void update(Class<?> clazz, String pro, String value, int id) {
//		dao.update(clazz, pro, value, id);
//	}

	public List<?> findList(final String sql) {
		return dao.findList(sql);
	}

	public Object findObject(final String sql) {
		return dao.findObject(sql);
	}
	
	
}
