package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.service.ArticleCategoryService;
import com.yl.service.ArticleService;
import com.yl.service.MemberService;

@Controller
@RequestMapping("/articleCategory")
public class ArticleCategoryController {

	@Autowired
	private  ArticleCategoryService articleCategoryService;
	

	
}
