package com.wowtour.account.service.Impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.wowtour.account.dao.AccountDao;
import com.wowtour.account.dao.FriendDao;
import com.wowtour.account.entity.Account;
import com.wowtour.account.entity.Friend;
import com.wowtour.account.service.AccountService;
import com.wowtour.account.service.EasemobService;
import com.wowtour.common.dao.IMybatisDao;
import com.wowtour.common.service.impl.MybatisServiceImpl;
import com.wowtour.frame.utils.Const;
import com.wowtour.frame.utils.page.Pagination;

/**
 * 
 * @author bear
 * @version 2015-07-15
 * @see com.wowtour.account.service.impl.Account
 */
@Service("accountService")
public class AccountServiceImpl extends MybatisServiceImpl<Account,Long> implements AccountService {
	@Resource
	private AccountDao accountDao;
	@Resource
	private FriendDao friendDao;
	@Resource
	private EasemobService easemobService;

	@Override
	protected IMybatisDao<Account, Long> getBaseDao() {
		return accountDao;
	}
	@Override
	public Account selectByUsername(String username) {
		return accountDao.selectByUsername(username);
	}

	@Override
	public boolean checkSameEmail(String mail) {
		Integer i = accountDao.checkSameEmail(mail);
		return i > 0;
	}

	public Long getIdbyEmail(String email){
		return accountDao.getIdbyEmail(email);
	}
	
	@Override
	public Set<String> findPermissions(String username) {
		return accountDao.findPermissions(username);
	}
	@Override
	public List<Map<String,Object>> getFriends(Long id,String status) {
		Preconditions.checkNotNull(id, "id不能为空");
		return friendDao.friendlist(id,status);
	}

	
	@Override
	public Integer designMakeFriend(Long userID,Long friendID,String status1,String status2){
		Preconditions.checkNotNull(userID, "userID不能为空");
		Preconditions.checkNotNull(friendID, "friendID不能为空");
		try {
			Friend entity = new Friend();
			entity.setUserID(userID);
			entity.setFriendID(friendID);
			entity.setStatus(status1);//申请好友
			Long id = friendDao.selectByUserFriend(userID, friendID);
			if(id != null){
				entity.setId(id);
				friendDao.update(entity);
			}else{
				friendDao.save(entity);
			}
			
			Friend entity1 = new Friend();
			entity1.setUserID(friendID);
			entity1.setFriendID(userID);
			entity1.setStatus(status2);//被申请好友
			Long id1 = friendDao.selectByUserFriend(friendID, userID);
			if(id1 != null){
				entity1.setId(id1);
				friendDao.update(entity1);
			}else{
				friendDao.save(entity1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@Override
	public List<Map<String,Object>> getFriends(Long id,Pagination pagination,String status) {
		Preconditions.checkNotNull(id, "id参数不能为空");
		Preconditions.checkNotNull(pagination.getRows(), "rows参数不能为空");
		Preconditions.checkNotNull(pagination.getPage(), "page参数不能为空");
		return friendDao.friendlistPage(id,status, pagination);
	}
	
	@Override
	public List<Map<String,Object>> getFriends(Long id,Pagination pagination,Map<String, Object> map) {
		return friendDao.friendListPage(pagination, map);
	}
	
	@Override
	public Long saveAccount(Account entity) {
		Preconditions.checkNotNull(entity.getEmail(), "邮箱不能为空");
		Preconditions.checkNotNull(entity.getPassword(), "密码不能为空");
		if(checkSameEmail(entity.getEmail())){
			throw new IllegalArgumentException("该邮箱已经注册");
		}
		String password = new Md5Hash(entity.getPassword()).toString();
		entity.setPassword(password);
		entity.setUsername("username"+Math.random()*100);
		entity.setDisabled(0);
		accountDao.save(entity);
		
		easemobService.createUserSingle(entity.getId().toString(), password);
		return entity.getId();
	}
	
	@Override
	public String getUserNameByID(Long userID) {
		return accountDao.getUserNameByID(userID);
	}

	@Override
	public void confirmMakeFriend(Long userID,Long friendID,String opt){
		String state;
		String action ="";
		String name = this.getUserNameByID(userID);
		if("true".equals(opt)){
			state = Const.Friend.status.valid;//同意添加为好友
			action = name+"同意添加您为好友";
		}else{
			state = Const.Friend.status.invalid;//决绝添加
			action = name+"拒绝添加您为好友";
		}
		designMakeFriend(userID, friendID, state, state);
		
		easemobService.sendCmsMessage(userID.toString(), friendID.toString(), action);
	}
	@Override
	public Integer designMakeFriend(@Param("userID") Long userID,
			@Param("friendName") String friendName,
			@Param("state1") String state1, @Param("state1") String state2) {
		
		Preconditions.checkNotNull(userID, "userID不能为空");
		Preconditions.checkNotNull(friendName, "friendName不能为空");
		
		Long friendID = this.getIdbyEmail(friendName);
		if(friendID == null){
			throw new IllegalArgumentException("不存在该用户");
		}
		try {
			Friend entity = new Friend();
			entity.setUserID(userID);
			entity.setFriendID(friendID);
			entity.setStatus(state1);//申请好友
			Long id = friendDao.selectByUserFriend(userID, friendID);
			if(id != null){
				entity.setId(id);
				friendDao.update(entity);
			}else{
				friendDao.save(entity);
			}
			
			Friend entity1 = new Friend();
			entity1.setUserID(friendID);
			entity1.setFriendID(userID);
			entity1.setStatus(state2);//被申请好友
			Long id1 = friendDao.selectByUserFriend(friendID, userID);
			if(id1 != null){
				entity1.setId(id1);
				friendDao.update(entity1);
			}else{
				friendDao.save(entity1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}
