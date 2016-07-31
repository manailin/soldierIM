package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Article;
import com.yl.service.ArticleService;
import com.yl.service.articleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private  ArticleService articleService;
	

	 @RequestMapping(value="get",method= RequestMethod.GET)
	   public  Article  get(Long  id){
		   
		return articleService.get(id);	   
	   }
	   
	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  Boolean  insert(Article  article){
		   
		 return articleService.save(article);	   
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  Boolean  update(Article  article){
		   
		 return articleService.update(article);	   
	   }
	   
	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  Boolean  delete(Long id){
		   
		 return articleService.delete(id);	   
	   }
}
