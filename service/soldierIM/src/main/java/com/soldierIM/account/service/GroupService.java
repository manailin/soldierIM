package com.wowtour.account.service;

import java.util.List;
import java.util.Map;

import com.wowtour.account.entity.Account;
import com.wowtour.account.entity.Group;
import com.wowtour.account.entity.GroupMember;
import com.wowtour.common.service.IMybatisService;


public interface GroupService extends IMybatisService<Group,Long> {

	public Long getOwnerbyGoupID(Long groupID);
	
	public List<Map<String,Object>> getAllMemberbyGroup(Long id);
	
	public Long buildGroup(Group entity);
	
	public Integer delByGroupAndUser(Long groupID,Long userID);
	
	public Long getByGroupAndUser(Long groupID,Long userID);
	
	public Integer saveGroupMmeber(GroupMember entity);
	
	public void batchSave(Group entity,String userIds);
	
	public Long buildGroupBatch(Group entity,String ids);
	
	public List<Map<String,Object>> getGroupList(Long id);
	
	//直接加人入群，不发送消息
	public void addUsertoGroup(Long groupID,Long userID);
	
	public void disableGroup(Long groupID);
	
	//邀请某人入群，发送消息
	public void reqUsertoGroup(Long groupID,Long userID);
	
	public List<Map<String,Object>> getJionGroups(Long userID);
	 
	public List<Map<String,Object>> getOwnGroups(Long userID);

	void reqUsertoGroup(Long groupID, String userName);

	void addUsertoGroup(Long groupID, String userName);
	
}
