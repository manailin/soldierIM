package com.wowtour.account.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface EasemobService {

	/**
	 * 创建群组
	 * @param entity
	 * @return
	 */
	public ObjectNode buildGroup(String gname,String desc,String ownerID);
	
	/**
	 * 发送透传消息
	 * @param from
	 * @param to
	 * @param action
	 * @return
	 */
	public ObjectNode sendCmsMessage(String from,String to,String action);
	/**
	 * 添加某人入群
	 * @param groupID
	 * @param userid
	 * @return
	 */
	public ObjectNode addUserToGroup(String groupID,String userid);
	/**
	 * 群删除某人
	 * @param groupid
	 * @param userid
	 * @return
	 */
	public ObjectNode deleteUserFromGroup(String groupid, String userid);
	/**
	 * 环信服务器端删除用户
	 * @param userid
	 * @return
	 */
	public ObjectNode deleteUserByKey(String userid);
	/**
	 * 环信服务器删除群组
	 * @param groupId
	 * @return
	 */
	public ObjectNode deleteGroup(String groupId);
	/**
	 * 环信服务器注册某用户
	 * @param userId
	 * @param password
	 * @return
	 */
	public ObjectNode createUserSingle(String userId,String password);
}
