package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Log;
import com.yl.domain.Member;
import com.yl.service.ILogService;
import com.yl.service.IMemberService;
import com.yl.service.imp.LogServiceImpl;

@Controller
@RequestMapping("/log")
public class LogController {

	@Autowired
	private  LogServiceImpl logService;

	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  void  insert(Log log ){

		logService.save(log);
	   }

}
