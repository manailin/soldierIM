package com.yl.service;


import java.io.Serializable;
import java.util.List;


/**
 * Service - ����
 * 
 * @author SHOP++ Team
 * @version 3.0
 */
public interface baseService<T, ID extends Serializable> {

	/**
	 * ����ʵ�����
	 * 
	 * @param id
	 *            ID
	 * @return ʵ��������������򷵻�null
	 */
	T find(ID id);

	/**
	 * ��������ʵ����󼯺�
	 * 
	 * @return ����ʵ����󼯺�
	 */
	List<T> findAll();

	/**
	 * ����ʵ����󼯺�
	 * 
	 * @param ids
	 *            ID
	 * @return ʵ����󼯺�
	 */
	List<T> findList(ID... ids);

	/**
	 * ����ʵ����󼯺�
	 * 
	 * @param count
	 *            ����
	 * @param filters
	 *            ɸѡ
	 * @param orders
	 *            ����
	 * @return ʵ����󼯺�
	 */
	
	/**
	 * ����ʵ�����
	 * 
	 * @param entity
	 *            ʵ�����
	 */
	void save(T entity);

	/**
	 * ����ʵ�����
	 * 
	 * @param entity
	 *            ʵ�����
	 * @return ʵ�����
	 */
	T update(T entity);

	/**
	 * ����ʵ�����
	 * 
	 * @param entity
	 *            ʵ�����
	 * @param ignoreProperties
	 *            ��������
	 * @return ʵ�����
	 */
	T update(T entity, String... ignoreProperties);

	/**
	 * ɾ��ʵ�����
	 * 
	 * @param id
	 *            ID
	 */
	void delete(ID id);

	/**
	 * ɾ��ʵ�����
	 * 
	 * @param ids
	 *            ID
	 */
	void delete(ID... ids);

	/**
	 * ɾ��ʵ�����
	 * 
	 * @param entity
	 *            ʵ�����
	 */
	void delete(T entity);
	
	

}