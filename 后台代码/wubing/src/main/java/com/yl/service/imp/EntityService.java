package com.yl.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yl.dao.BaseMapper;
import com.yl.domain.BaseEntity;
import com.yl.service.BaseService;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
@Service
public abstract  class EntityService<D extends BaseMapper<T>, T extends BaseEntity<T>> implements BaseService<D, T>{

	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(Long id) {
		return dao.get(id);
	}

	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}

	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}


/*	*//**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 *//*
	public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}
*/
	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {

			dao.insert(entity);

	}

	/**
	 * 更新数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void update(T entity) {
		dao.update(entity);
	}

	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void delete(Long id) {
		dao.deleteById(id);
	}

}
