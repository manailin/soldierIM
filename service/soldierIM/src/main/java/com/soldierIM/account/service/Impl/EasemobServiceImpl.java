package com.wowtour.account.service.Impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wowtour.account.service.EasemobService;
import com.wowtour.jersey.api.EasemobChatGroups;
import com.wowtour.jersey.api.EasemobIMUsers;
import com.wowtour.jersey.api.EasemobMessages;
import com.wowtour.jersey.comm.Constants;

@Service("easemobService")
public class EasemobServiceImpl implements EasemobService{
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	/**
	 * 创群	
	 * @param entity
	 * @return
	 */
	public ObjectNode buildGroup(String gname,String desc,String ownerID){
		ObjectNode dataObjectNode = factory.objectNode();
		dataObjectNode.put("groupname", gname);
		dataObjectNode.put("desc", desc);
		dataObjectNode.put("approval", true);
		dataObjectNode.put("public", true);
		dataObjectNode.put("maxusers", 333);
		dataObjectNode.put("owner", ownerID);
		ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
		arrayNode.add(ownerID);
		dataObjectNode.put("members", arrayNode);
		ObjectNode creatChatGroupNode = EasemobChatGroups.creatChatGroups(dataObjectNode);
		return creatChatGroupNode;
	}
	
	/**
	 * 发送透传消息
	 * @param from
	 * @param to
	 * @param action
	 * @return
	 */
	public ObjectNode sendCmsMessage(String from,String to,String action){
        String targetTypeus = "users";
        ObjectNode ext = factory.objectNode();
        ArrayNode targetusers = factory.arrayNode();
        targetusers.add(to);
        ObjectNode cmdmsg = factory.objectNode();
        cmdmsg.put("action", action);
        cmdmsg.put("type","cmd");
        ObjectNode sendcmdMessageusernode = EasemobMessages.sendMessages(targetTypeus, targetusers, cmdmsg, from, ext);
        return sendcmdMessageusernode;
	}

	@Override
	public ObjectNode addUserToGroup(String groupID, String userid) {
		ObjectNode node = EasemobChatGroups.addUserToGroup(groupID, userid);
		return node;
	}

	@Override
	public ObjectNode deleteUserFromGroup(String groupid, String userid) {
		ObjectNode node = EasemobChatGroups.deleteUserFromGroup(groupid, userid);
		return node;
	}

	@Override
	public ObjectNode deleteUserByKey(String userid) {
		ObjectNode node = EasemobIMUsers.deleteIMUserByUserPrimaryKey(userid);
		return node;
	}

	@Override
	public ObjectNode deleteGroup(String groupId) {
		return EasemobChatGroups.deleteChatGroups(groupId);
	}

	@Override
	public ObjectNode createUserSingle(String userId,String password) {
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username",userId);
        datanode.put("password",password);
        ObjectNode node = EasemobIMUsers.createNewIMUserSingle(datanode);
        return node;
	}
	
	

}
