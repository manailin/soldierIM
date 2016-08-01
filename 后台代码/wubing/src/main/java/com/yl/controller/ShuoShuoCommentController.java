package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yl.domain.shuoShuoComment;
import com.yl.service.IShuoShuoCommentService;
import com.yl.service.imp.ShuoShuoCommentServiceImpl;

@Controller
@RequestMapping("/shuoshuo_comment")
public class ShuoShuoCommentController {

	@Autowired
	private  ShuoShuoCommentServiceImpl shuoShuoCommentService;

	 @RequestMapping(value="get",method= RequestMethod.GET)
	   public  shuoShuoComment  get(String  id){

		return shuoShuoCommentService.get(id);
	   }

	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  void  insert(shuoShuoComment  shuoShuoComment){

		 shuoShuoCommentService.save(shuoShuoComment);
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  void  update(shuoShuoComment  shuoShuoComment){

		shuoShuoCommentService.update(shuoShuoComment);
	   }

	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  void  delete(String id){

		  shuoShuoCommentService.delete(id);
	   }

}
