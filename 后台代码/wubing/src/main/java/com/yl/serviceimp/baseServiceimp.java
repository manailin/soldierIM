package com.yl.serviceimp;

import java.io.Serializable;
import java.util.List;

import com.yl.dao.BaseDao;
import com.yl.domain.BaseEntity;
import com.yl.service.EntityService;

public abstract class baseServiceimp<T>{
	
	public T find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<T> findList(Serializable... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public T update(T entity, String... ignoreProperties) {
		// TODO Auto-generated method stub
		return null;
	}


	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Serializable... ids) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

}
