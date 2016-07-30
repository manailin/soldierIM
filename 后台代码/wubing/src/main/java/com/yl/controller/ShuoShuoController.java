package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.service.MemberService;
import com.yl.service.ShuoShuoService;

@Controller
@RequestMapping("/shuoshuo")
public class ShuoShuoController {

	@Autowired
	private  ShuoShuoService shuoShuoService;
	


}
