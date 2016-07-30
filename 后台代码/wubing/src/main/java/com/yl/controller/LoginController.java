package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private  MemberService userService;
	

	@RequestMapping(value="/index",method= RequestMethod.GET)
	public @ResponseBody
     String login(String name ,String password){
		
		return userService.login(name, password);
	}
}
