package com.wowtour.account.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.wowtour.account.entity.Account;
import com.wowtour.common.dao.IMybatisDao;

/**
 * 
 * @author <Auto generate>
 * @version 2015-07-15
 * @see com.wowtour.account.dao.Account
 */
@Repository
public interface AccountDao extends IMybatisDao<Account,Long>{

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Account selectAccountById(Long id) throws Exception;


	/**
	 * 根据用户名和用户类型查找用户
	 * 
	 * @param username
	 * @param userType
	 * @return
	 */
	Account selectByUsername(String username);

	/**
	 * 获取用户权限标识
	 * 
	 * @param username
	 * @param type
	 * @return
	 */
	Set<String> findPermissions(String username);	
	
	Integer checkSameEmail(String email);
	
	
	String getUserNameByID(Long userID);
	
	Long getIdbyEmail(String email);

}
