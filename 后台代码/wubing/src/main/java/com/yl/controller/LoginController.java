package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.service.IMemberService;
import com.yl.service.imp.MemberServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private  MemberServiceImpl userService;


	@RequestMapping(value="/index",method= RequestMethod.GET)
	public @ResponseBody
     String login(String name ,String password){

		return userService.login(name, password);
	}
}
