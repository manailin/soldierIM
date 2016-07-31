package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.shuoShuoComment;
import com.yl.service.shuoShuoCommentService;
import com.yl.service.ShuoShuoCommentService;

@Controller
@RequestMapping("/shuoshuo_comment")
public class ShuoShuoCommentController {

	@Autowired
	private  ShuoShuoCommentService shuoShuoCommentService;
	
	 @RequestMapping(value="get",method= RequestMethod.GET)
	   public  shuoShuoComment  get(Long  id){
		   
		return shuoShuoCommentService.get(id);	   
	   }
	   
	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  Boolean  insert(shuoShuoComment  shuoShuoComment){
		   
		 return shuoShuoCommentService.save(shuoShuoComment);	   
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  Boolean  update(shuoShuoComment  shuoShuoComment){
		   
		 return shuoShuoCommentService.update(shuoShuoComment);	   
	   }
	   
	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  Boolean  delete(Long id){
		   
		 return shuoShuoCommentService.delete(id);	   
	   }

}
