package com.wowtour.account.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.wowtour.account.dao.AccountDao;
import com.wowtour.account.dao.GroupDao;
import com.wowtour.account.dao.GroupMemberDao;
import com.wowtour.account.entity.Account;
import com.wowtour.account.entity.Group;
import com.wowtour.account.entity.GroupMember;
import com.wowtour.account.service.EasemobService;
import com.wowtour.account.service.GroupService;
import com.wowtour.common.dao.IMybatisDao;
import com.wowtour.common.service.impl.MybatisServiceImpl;
import com.wowtour.frame.shiro.ShiroSessionUtils;
import com.wowtour.frame.utils.Const;
import com.wowtour.frame.utils.StringUtil;
import com.wowtour.frame.utils.ValidatorUtils;

@Service("groupService")
public class GroupServiceImpl extends MybatisServiceImpl<Group,Long> implements GroupService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private GroupDao groupDao;
	@Resource
	private AccountDao accountDao;
	@Resource
	private GroupMemberDao groupMemberDao;
	@Resource
	private EasemobService easemobService;

	@Override
	protected IMybatisDao<Group, Long> getBaseDao() {
		return groupDao;
	}

	public Long getOwnerbyGoupID(Long groupID){
		return groupDao.getOwnerbyGoupID(groupID);
	}

	public String getGroupNameByID(Long groupID){
		return groupDao.getGroupNameByID(groupID);
	}
	@Override
	public Long buildGroup(Group entity) {
		String message = ValidatorUtils.validate(entity);
		if(StringUtils.isNotBlank(message)){
			throw new IllegalArgumentException(message);
		}

		entity.setStatus(Const.Group.status.valid);
		save(entity);
		return entity.getId();
	}
	
	@Override
	public Long buildGroupBatch(Group entity,String ids){
		Long id = buildGroup(entity);
		batchSave(entity,ids);
		return id;
	}

	
	@Override
	public Integer delByGroupAndUser(Long groupID, Long userID) {
		Preconditions.checkNotNull(groupID, "groupID不能为空");
		Preconditions.checkNotNull(userID, "userID不能为空");
		Long id = this.getOwnerbyGoupID(groupID);
		if(id.equals(userID)){
			//if current user is group owner, disable this group
			groupDao.disableGroup(groupID);
		}
		return groupMemberDao.delByGroupAndUser(groupID, userID);
	}
	
	@Override
	public List<Map<String,Object>> getAllMemberbyGroup(Long id){
		return groupMemberDao.getAllMemberbyGroup(id);
	}

	@Override
	public Long getByGroupAndUser(Long groupID, Long userID) {
		Preconditions.checkNotNull(groupID, "groupID不能为空");
		Preconditions.checkNotNull(userID, "userID不能为空");
		return groupMemberDao.getByGroupAndUser(groupID, userID);
	}

	@Override
	public Integer saveGroupMmeber(GroupMember entity) {
		Preconditions.checkNotNull(entity.getGroupID(), "groupID不能为空");
		Preconditions.checkNotNull(entity.getUserID(), "userID不能为空");
		Long i = getByGroupAndUser(entity.getGroupID(),entity.getUserID());
		if(i == null){//not exist yet
			groupMemberDao.save(entity);
		}else{
			entity.setId(i);
			groupMemberDao.update(entity);
		}
		return 1;
	}

	@Override
	public void batchSave(Group entity,String userIds) {
		Preconditions.checkNotNull(userIds, "userID不能为空");	
		List<GroupMember> list = new ArrayList<GroupMember>();
		List<String> strs = StringUtil.toList(userIds);
		for(String str:strs){
			GroupMember mem = new GroupMember();
			mem.setGroupID(entity.getId());
			mem.setIsNotify(entity.getIsNotify());
			mem.setIsAccept(entity.getIsAccept());
			mem.setJoinTime(new Date());
			mem.setUserID(Long.getLong(str));
			list.add(mem);			
		}
		groupMemberDao.batchSave(list);
	}

	@Override
	public List<Map<String, Object>> getGroupList(Long id) {
		return null;
	}
	
	@Override	
	public void addUsertoGroup(Long groupID,Long userID){
		Preconditions.checkNotNull(groupID, "groupID不能为空");
		Preconditions.checkNotNull(userID, "userID不能为空");
		GroupMember entity = new GroupMember();
		Group group = groupDao.findById(groupID);
		entity.setGroupID(groupID);
		entity.setUserID(userID);
		entity.setIsAccept(Const.Group.isAccept.success);
		entity.setJoinTime(new Date());
		Integer i = saveGroupMmeber(entity);
		if(i > 0){
			easemobService.addUserToGroup(group.getHuanGroupID(), userID.toString());
		}
	}

	@Override	
	public void addUsertoGroup(Long groupID,String userName){
		Preconditions.checkNotNull(groupID, "groupID不能为空");
		Preconditions.checkNotNull(userName, "userName不能为空");
		GroupMember entity = new GroupMember();
		Account account = accountDao.selectByUsername(userName);
		Group group = groupDao.findById(groupID);
		entity.setGroupID(groupID);
		entity.setUserID(account.getId());
		entity.setIsAccept(Const.Group.isAccept.success);
		entity.setJoinTime(new Date());
		Integer i = saveGroupMmeber(entity);
		if(i > 0){
			easemobService.addUserToGroup(group.getHuanGroupID(), account.getId().toString());
			logger.info(groupID.toString()+"======"+ account.getId().toString());
		}
	}
	
	@Override
	public void reqUsertoGroup(Long groupID, Long userID) {
		Preconditions.checkNotNull(groupID, "groupID不能为空");
		Preconditions.checkNotNull(userID, "userID不能为空");
		GroupMember entity = new GroupMember();
		Account account = accountDao.findById(userID);
		entity.setGroupID(groupID);
		entity.setUserID(userID);
		entity.setIsAccept(Const.Group.isAccept.waiting);
		entity.setJoinTime(new Date());
		Integer i = saveGroupMmeber(entity);
		if(i > 0){
			Account a = ShiroSessionUtils.getLoginAccount();
			Group group = this.findById(groupID);
			if(a.getId().longValue()!=userID.longValue()){
				//申请加入群
				String action = account.getUsername() + "申请加入群";
				easemobService.sendCmsMessage(userID.toString(), group.getOwnerID().toString(), action);
			}else{
				//群主邀请加入
				String action = a.getUsername() + "群邀请您加入";
				easemobService.sendCmsMessage(groupID.toString(), userID.toString(), action);
			}
		}
	}
	
	@Override
	public void reqUsertoGroup(Long groupID, String userName) {
		Preconditions.checkNotNull(groupID, "groupID不能为空");
		Preconditions.checkNotNull(userName, "userName不能为空");
		GroupMember entity = new GroupMember();
		Account account = accountDao.selectByUsername(userName);
		entity.setGroupID(groupID);
		entity.setUserID(account.getId());
		entity.setIsAccept(Const.Group.isAccept.waiting);
		entity.setJoinTime(new Date());
		Integer i = saveGroupMmeber(entity);
		if(i > 0){
			Account a = ShiroSessionUtils.getLoginAccount();
			Group group = this.findById(groupID);
			if(!a.getUsername().equals(userName)){
				//群主邀请加入
				String action = userName + "申请加入群";
				easemobService.sendCmsMessage(account.getId().toString(), group.getOwnerID().toString(), action);
			}else{//申请加入群
				String action = userName + "群邀请您加入";
				easemobService.sendCmsMessage(groupID.toString(), account.getId().toString(), action);
			}
		}	
	}

	@Override
	public List<Map<String, Object>> getJionGroups(Long userID) {
		return groupMemberDao.getJionGroups(userID);
	}

	@Override
	public List<Map<String, Object>> getOwnGroups(Long userID) {
		return groupMemberDao.getOwnGroups(userID);
	}

	@Override
	public void disableGroup(Long groupID) {
		groupDao.disableGroup(groupID);
	}
}
