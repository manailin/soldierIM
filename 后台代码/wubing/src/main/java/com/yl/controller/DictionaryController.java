package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yl.domain.Dictionary;
import com.yl.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private  DictionaryService dictionnaryService;


	@RequestMapping(value="get",method= RequestMethod.GET)
	   public  Dictionary  get(String  id){

		return dictionnaryService.get(id);
	   }

	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  void  insert(Dictionary  dictionnary){

		  dictionnaryService.save(dictionnary);
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  void  update(Dictionary  dictionnary){

		  dictionnaryService.update(dictionnary);
	   }

	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  void  delete(String id){

		  dictionnaryService.delete(id);
	   }
}
