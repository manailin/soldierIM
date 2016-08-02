package com.yl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yl.dao.BaseMapper;
import com.yl.domain.BaseEntity;

/**
 * Service基类
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public interface BaseService<D extends BaseMapper<T>, T extends BaseEntity<T>> {

	public T get(T entity);

	public T get(String id);

	public T get(Long id);

	public void save(T entity);

	public void delete(T entity);

	public void delete(String id);

	public void update(T entity);

	public List<T> findAllList();

}
