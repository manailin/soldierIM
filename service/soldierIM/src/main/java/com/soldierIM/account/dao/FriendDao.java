package com.wowtour.account.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wowtour.account.entity.Friend;
import com.wowtour.common.dao.IMybatisDao;
import com.wowtour.frame.utils.page.Pagination;

@Repository
public interface FriendDao extends IMybatisDao<Friend,Long>{

	public Long selectByUserFriend(@Param("userID")Long userID, @Param("friendID") Long friendID);
	
	/**
	 * 分页查找
	 * 
	 * @param account
	 * @param pagination
	 * @return
	 */
	List<Map<String,Object>> friendlistPage(@Param("userID") Long userID, @Param("status") String status,
			@Param("pagination") Pagination pagination);
	
	List<Map<String,Object>> friendlist(@Param("userID") Long userID, @Param("status") String status);
	
	List<Map<String,Object>> friendListPage(@Param("pagination") Pagination pagination,@Param("map") Map map);
}
