package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.User;
import com.yl.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private  UserService userService;
	

	@RequestMapping(value="/login",method= RequestMethod.GET)
	public @ResponseBody
     String login(String name ,String password){
		
		return userService.login(name, password);
	}
}
