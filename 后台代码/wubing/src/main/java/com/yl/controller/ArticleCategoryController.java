package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yl.domain.ArticleCategory;
import com.yl.service.imp.ArticleCategoryServiceImpl;

@Controller
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

	@Autowired
	private  ArticleCategoryServiceImpl articleCategoryService;


	@RequestMapping(value="/get",method= RequestMethod.GET)
	   public  ArticleCategory  get(String  id){

		return articleCategoryService.get(id);
	   }

	   @RequestMapping(value="/insert",method= RequestMethod.POST)
	   public  void  insert(ArticleCategory  articleCategory){

		  articleCategoryService.save(articleCategory);
	   }

	   @RequestMapping(value="/update",method= RequestMethod.POST)
	   public  void  update(ArticleCategory  articleCategory){

		  articleCategoryService.update(articleCategory);
	   }

	   @RequestMapping(value="/delete",method= RequestMethod.POST)
	   public  void  delete(String id){

		  articleCategoryService.delete(id);
	   }
}
