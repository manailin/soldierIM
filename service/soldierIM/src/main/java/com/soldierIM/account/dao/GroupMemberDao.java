package com.wowtour.account.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wowtour.account.entity.GroupMember;
import com.wowtour.common.dao.IMybatisDao;

/**
 * 
 * @author bear
 * @version 2015-07-15
 * @see com.wowtour.account.dao.Account
 */
@Repository
public interface GroupMemberDao extends IMybatisDao<GroupMember,Long>{
	
	 public Integer delByGroupAndUser(@Param("groupID")Long groupID, @Param("userID")Long userID);
	 
	 public Long getByGroupAndUser(@Param("groupID")Long groupID, @Param("userID")Long userID);
	 
	 public void batchSave(List<GroupMember> list);
	 
	 public List<Map<String,Object>> getAllMemberbyGroup(Long id);
	 
	 public List<Map<String,Object>> getOwnGroups(Long userID);
	 
	 public List<Map<String,Object>> getJionGroups(Long userID);
	 
}