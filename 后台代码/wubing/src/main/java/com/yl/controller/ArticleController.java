package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yl.domain.Article;
import com.yl.service.imp.ArticleServiceImpl;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private  ArticleServiceImpl articleService;


	 @RequestMapping(value="get",method= RequestMethod.GET)
	   public  Article  get(String  id){

		return articleService.get(id);
	   }

	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  void  insert(Article  article){

		  articleService.save(article);
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  void  update(Article  article){

		  articleService.update(article);
	   }

	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  void  delete(String id){

		  articleService.delete(id);
	   }
}
