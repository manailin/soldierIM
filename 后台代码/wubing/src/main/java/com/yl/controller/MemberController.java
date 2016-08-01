package com.yl.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private  MemberService memberService;

   @RequestMapping(value="get",method= RequestMethod.GET)
   public  Member  get(String  id){

	return memberService.get(id);
   }

   @RequestMapping(value="insert",method= RequestMethod.POST)
   public  void  insert(Member  member){

	  memberService.save(member);
   }

   @RequestMapping(value="update",method= RequestMethod.POST)
   public  void  update(Member  member){

	  memberService.update(member);
   }

   @RequestMapping(value="delete",method= RequestMethod.POST)
   public  void  delete(String id){

	  memberService.delete(id);
   }
}
