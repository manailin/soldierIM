package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Dictionary;
import com.yl.service.DictionaryService;
import com.yl.service.dictionnaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private  DictionaryService dictionnaryService;
	

	@RequestMapping(value="get",method= RequestMethod.GET)
	   public  Dictionary  get(Long  id){
		   
		return dictionnaryService.get(id);	   
	   }
	   
	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  Boolean  insert(Dictionary  dictionnary){
		   
		 return dictionnaryService.save(dictionnary);	   
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  Boolean  update(Dictionary  dictionnary){
		   
		 return dictionnaryService.update(dictionnary);	   
	   }
	   
	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  Boolean  delete(Long id){
		   
		 return dictionnaryService.delete(id);	   
	   }
}
