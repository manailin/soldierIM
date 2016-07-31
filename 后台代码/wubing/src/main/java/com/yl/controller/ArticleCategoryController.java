package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.ArticleCategory;
import com.yl.service.ArticleCategoryService;
import com.yl.service.ArticleService;

@Controller
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

	@Autowired
	private  ArticleCategoryService articleCategoryService;
	

	@RequestMapping(value="get",method= RequestMethod.GET)
	   public  ArticleCategory  get(Long  id){
		   
		return articleCategoryService.get(id);	   
	   }
	   
	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  Boolean  insert(ArticleCategory  articleCategory){
		   
		 return articleCategoryService.save(articleCategory);	   
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  Boolean  update(ArticleCategory  articleCategory){
		   
		 return articleCategoryService.update(articleCategory);	   
	   }
	   
	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  Boolean  delete(Long id){
		   
		 return articleCategoryService.delete(id);	   
	   }
}
