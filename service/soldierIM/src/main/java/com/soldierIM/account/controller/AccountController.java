package com.wowtour.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wowtour.account.entity.Account;
import com.wowtour.account.service.AccountService;
import com.wowtour.account.service.EasemobService;
import com.wowtour.frame.filter.WebContext;
import com.wowtour.frame.utils.Const;
import com.wowtour.frame.utils.ResponseUtils;
import com.wowtour.frame.utils.page.Pagination;

/**
 * 
 * @author bear
 * @version 2015-07-15
 * @see com.wowtour.account.web.Account
 */
@Controller
public class AccountController {
	@Resource
	private AccountService accountService;
	@Resource
	private EasemobService easemobService;

	/**
	 * 查看账号信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/account/get" ,method=RequestMethod.GET)
	@ResponseBody
	public Object get(@RequestParam Long userID) {
		try {
			Account account = accountService.findById(userID);
			return ResponseUtils.buildSuccessRes(account);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}

	
	/**
	 * 获取某人的朋友列表
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/account/get_friends",method=RequestMethod.GET)
	@ResponseBody
	public Object getFriends(@RequestParam Long userID){
		try{
			List<Map<String,Object>> list = accountService.getFriends(userID,Const.Friend.status.valid);
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("friends", list);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 获取待验证的朋友列表,不带分页
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/friend/get_checked_friends",method=RequestMethod.GET)
	@ResponseBody
	public Object getCheckedFriends(@RequestParam Long userID){
		try{
			List<Map<String,Object>> list = accountService.getFriends(userID,Const.Friend.status.waitingChecked);
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("friends", list);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 获取某人的朋友列表,分页展示
	 * /friends?by=userid&page=2&rows=10
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/account/get_friends_page",method=RequestMethod.GET)
	@ResponseBody
	public Object getFriendsByPage(@RequestParam Long userID,@RequestParam int pageSize,@RequestParam  int pageNo){
		try{
			Pagination pagination = new Pagination();
			pagination.setPage(pageNo);
			pagination.setRows(pageSize);
			List<Map<String,Object>> list = accountService.getFriends(userID, pagination,Const.Friend.status.valid);
			Map<String,Object> map = new WeakHashMap<String,Object>();
			map.put("totalCount", pagination.getTotal());
			map.put("totalPage", pagination.getTotalPage());
			map.put("friends", list);
			return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	
	/**
	 * 获取某段时间内某人的待验证朋友列表,分页展示
	 * /get_new_friends?userID=12&page=2&rows=10
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/friend/get_new_friends",method=RequestMethod.GET)
	@ResponseBody
	public Object getNewFriendsByPage(@RequestParam Long userID,@RequestParam int pageSize,@RequestParam int pageNo){
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			HttpServletRequest req = WebContext.currentRequest();
			String startTime = req.getParameter("startTime");
			String endTime = req.getParameter("endTime");
			String msgCount = req.getParameter("msgCount");
			if(StringUtils.isNotBlank(startTime)){
				map.put("startTime", Long.parseLong(startTime));
			}
			if(StringUtils.isNotBlank(endTime)){
				map.put("endTime", Long.parseLong(endTime));
			}
			if(StringUtils.isNotBlank(msgCount)){
				map.put("msgCount", Integer.getInteger(msgCount));
			}

			Pagination pagination = new Pagination();
			pagination.setPage(pageNo);
			pagination.setRows(pageSize);
			
			map.put("pagination", pagination);
			List<Map<String,Object>> list = accountService.getFriends(userID,pagination,map);
			Map<String,Object> resultap = new WeakHashMap<String,Object>();
			map.put("totalCount", pagination.getTotal());
			map.put("totalPage", pagination.getTotalPage());
			map.put("friends", list);
			return ResponseUtils.buildSuccessRes(resultap);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * 删除好友,不发送透传消息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/friend/delete",method=RequestMethod.GET)
	@ResponseBody
	public Object delFriend(@RequestParam Long userID,@RequestParam Long friendID){
		try{
			accountService.designMakeFriend(userID, friendID, Const.Friend.status.invalid, Const.Friend.status.invalid);
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * a向b请求建立朋友关系
	 * @param userID
	 * @param friendID
	 * @return
	 */
	@RequestMapping(value="/friend/add",method=RequestMethod.POST)
	@ResponseBody
	public Object reqAddFriend(@RequestParam Long userID,@RequestParam String friendName){
		try {
			
			int result = accountService.designMakeFriend(userID, friendName, Const.Friend.status.waiting, Const.Friend.status.waitingChecked);
			if(result ==1){
				String name = accountService.getUserNameByID(userID); 
				Long friendID = accountService.getIdbyEmail(friendName);
				String action =name+"请求添加您为好友";
				easemobService.sendCmsMessage(userID.toString(), friendID.toString(), action);
			}
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	/**
	 * b同意或者拒绝添加a好友. 1 同意 2拒绝
	 * @param id
	 * @param opt
	 * @return
	 */
	@RequestMapping(value="/friend/confirm",method=RequestMethod.GET)
	@ResponseBody
	public Object respondMakeFriend(@RequestParam Long userID,@RequestParam Long friendID,@RequestParam String opt) {
		try{
			accountService.confirmMakeFriend(userID, friendID, opt);
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
}
