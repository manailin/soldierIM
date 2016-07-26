package com.wowtour.account.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wowtour.account.entity.Account;
import com.wowtour.account.service.AccountService;
import com.wowtour.frame.filter.WebContext;
import com.wowtour.frame.utils.Const;
import com.wowtour.frame.utils.ResponseUtils;
import com.wowtour.frame.utils.ValidatorUtils;

/**
 * 
 * @author bear
 * @version 2015-07-15
 * @see com.wowtour.account.web.Account
 */
@Controller
public class RegisterController {
	@Resource
	private AccountService accountService;
	
	/**
	 * 完善个人信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/register/update",method=RequestMethod.GET)
	@ResponseBody
	public Object perfectAccount(@RequestBody Account account) {
		try {
			String message = ValidatorUtils.validate(account);
			if (StringUtils.isBlank(message)) {
				accountService.update(account);
			} 
			return ResponseUtils.buildSuccessRes(null);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}
	
	public Object activeAccount(){
		return null;
		
	}
	
	
	/**
	 * 注册
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Object register() {
		try{
			HttpServletRequest req = WebContext.currentRequest();
			Account account = new Account();
			account.setEmail((String)req.getParameter("email"));
			account.setPassword((String)req.getParameter("password"));
			Long id = accountService.saveAccount(account);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id", id);
		return ResponseUtils.buildSuccessRes(map);
		}catch(Exception e){
			e.printStackTrace();
			return ResponseUtils.buildErrorRes(Const.GENERAL_ERROR, e.getMessage());
		}
	}

}
