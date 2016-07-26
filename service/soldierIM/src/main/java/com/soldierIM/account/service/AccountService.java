package com.wowtour.account.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.wowtour.account.entity.Account;
import com.wowtour.common.service.IMybatisService;
import com.wowtour.frame.utils.page.Pagination;

/**
 * 
 * @author <Auto generate>
 * @version 2015-07-15
 * @see com.wowtour.account.service.Account
 */
public interface AccountService  extends IMybatisService<Account,Long> {
	
	boolean checkSameEmail(String mail);
	
	Long saveAccount(Account entity);

	Account selectByUsername(String username);

	List<Map<String,Object>> getFriends(Long id,String status);
	
	List<Map<String,Object>> getFriends(@Param("userID") Long id,
			@Param("pagination") Pagination pagination,@Param("status")String status);
	
	/**
	 * 好友公共接口，申请添加好友，同意或者拒绝添加好友，删除好友
	 * @param userID
	 * @param friendID
	 * @param state1
	 * @param state2
	 * @return
	 */
	Integer designMakeFriend(@Param("userID") Long userID,@Param("friendID") Long friendID, @Param("state1") String state1,@Param("state1") String state2);
	
	Integer designMakeFriend(@Param("userID") Long userID,@Param("friendName") String friendName, @Param("state1") String state1,@Param("state1") String state2);

//	List<Account> getFriends(Long id, int rows, int page,String status);
	
	String getUserNameByID(@Param("userID") Long userID);
	
	void confirmMakeFriend(@Param("userID") Long userID,@Param("friendID") Long friendID,@Param("opt") String opt);

	List<Map<String,Object>> getFriends(Long id,@Param("pagination") Pagination pagination,Map<String, Object> map);

	Set<String> findPermissions(String username);
	
	public Long getIdbyEmail(String email);
	
}
