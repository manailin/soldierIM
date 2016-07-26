package com.wowtour.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wowtour.account.entity.Account;
import com.wowtour.account.entity.Group;
import com.wowtour.account.service.EasemobService;
import com.wowtour.account.service.GroupService;
import com.wowtour.frame.filter.WebContext;
import com.wowtour.frame.shiro.ShiroSessionUtils;
import com.wowtour.frame.utils.Const;
import com.wowtour.frame.utils.ResponseUtils;

/**
 * 
 * @author bear
 * @version 2015-07-15
 * @see com.wowtour.account.web.Account
 */
@Controller
@RequestMapping(value = "/group")
public class GroupController {
	@Resource
	private GroupService groupService;
	@Resource
	private EasemobService easemobService;
	
	/**
	 * 建群
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/build_group",method=RequestMethod.POST)
	@ResponseBody
	public Object buildGroup(){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			
			Group entity = new Group();
			HttpServletRequest req = WebContext.currentRequest();
			String groupName =(String)req.getParameter("groupName");
			String desc =(String)req.getParameter("describ");
			entity.setGroupName(groupName);
			entity.setDescrib(desc);
			Account a = ShiroSessionUtils.getLoginAccount();
			entity.setOwnerID(a.getId());
			ObjectNode node = easemobService.buildGroup(entity.getGroupName(),entity.getDescrib(),entity.getOwnerID().toString());
			System.out.println(node.toString());
			String huanGroupID = node.findValue("groupid").asText();
			
			entity.setType(Const.Group.type.ordinary);
			entity.setIsNotify(Const.Group.isNotifyNewMsg.fail);
			entity.setIsAccept(Const.Group.isAccept.success);
			entity.setHuanGroupID(huanGroupID);
			
			Long groupId = groupService.buildGroup(entity);
			groupService.addUsertoGroup(groupId, entity.getOwnerID());
			map.put("groupID", groupId);
			map.put("huanGroupID", huanGroupID);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
//
//	/**
//	 * 拉多人建群，不发消息
//	 * @param entity
//	 * @return
//	 */
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	@ResponseBody
//	public Object buildGroup(@RequestBody Group entity,String ids){
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		ObjectNode node = easemobService.buildGroup(entity.getGroupName(),entity.getDesc(),entity.getOwnerID());
//		String huanGroupID = node.findValue("groupid").asText();
//		
//		entity.setHuanGroupId(huanGroupID);
//		entity.setType(Const.Group.type.ordinary);
//		entity.setIsNotify(Const.Group.isNotifyNewMsg.fail);
//		entity.setIsAccept(Const.Group.isAccept.success);
//		Long groupId = groupService.buildGroupBatch(entity,ids);
//		
//		map.put("id", groupId);
//		map.put("huanGroupID", huanGroupID);
//		return ResponseUtils.buildSuccessRes(map);
//	}
	
	/**
	 * 申请入群/群组邀请人加入
	 * @return
	 */
	@RequestMapping(value="/add_to_group",method=RequestMethod.POST)
	@ResponseBody
	public Object reqAddGroup(@RequestParam Long groupID,@RequestParam String userName){
		try {
			groupService.reqUsertoGroup(groupID, userName);
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	
	/**
	 * 直接添加进群，不放送消息
	 * @return
	 */
	@RequestMapping(value="/direct_add_group",method=RequestMethod.POST)
	@ResponseBody
	public Object addUserToGroup(@RequestParam Long groupID,@RequestParam String userName){
		try {
			groupService.addUsertoGroup(groupID, userName);
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 退群,删人
	 * @return
	 */
	@RequestMapping(value="/get_out",method=RequestMethod.POST)
	@ResponseBody
	public Object quitGroup(@RequestParam Long groupID,@RequestParam Long userID){
		try {
			Integer i = groupService.delByGroupAndUser(groupID, userID);
			if(i > 0){
				easemobService.deleteUserFromGroup(groupID.toString(), userID.toString());
				String action ="退出群";
				easemobService.sendCmsMessage(groupID.toString(), userID.toString(), action);
			}
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}

	
	
	/**
	 * 查找所加入的group
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="/get_join_groups",method=RequestMethod.GET)
	@ResponseBody
	public Object getAllGroupByPerson(@RequestParam Long userID){
		try {
			List<Map<String,Object>> list = groupService.getJionGroups(userID);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("groups", list);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 查找所创办的group
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="/get_own_groups",method=RequestMethod.GET)
	@ResponseBody
	public Object getOwnGroupByPerson(@RequestParam Long userID){
		try {
			List<Map<String,Object>> list = groupService.getOwnGroups(userID);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("groups", list);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 查找组成员
	 * @param groupID
	 * @return
	 */
	@RequestMapping(value="/get_members",method=RequestMethod.GET)
	@ResponseBody
	public Object getAllMemberbyGroup(@RequestParam Long groupID){
		try {
			List<Map<String,Object>> list = groupService.getAllMemberbyGroup(groupID);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("members", list);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 获取组详情
	 * @param groupID
	 * @return
	 */
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public Object getGroupById(@RequestParam Long groupID){
		try{
			Group entity = groupService.findById(groupID);
			entity.setMembers(groupService.getAllMemberbyGroup(groupID));
			
			return ResponseUtils.buildSuccessRes(entity);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}

	/**
	 * 删除群组
	 * @param groupID
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Object delGroupById(@RequestParam Long groupID){
		try{
			Group entity = groupService.findById(groupID);
			groupService.disableGroup(groupID);
			easemobService.deleteGroup(entity.getHuanGroupID());
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
}
