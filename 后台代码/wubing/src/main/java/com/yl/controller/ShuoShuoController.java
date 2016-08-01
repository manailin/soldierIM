package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yl.domain.ShuoShuo;
import com.yl.service.ShuoShuoService;

@Controller
@RequestMapping("/shuoshuo")
public class ShuoShuoController {

	@Autowired
	private  ShuoShuoService shuoShuoService;

	@RequestMapping(value="get",method= RequestMethod.GET)
	   public  ShuoShuo  get(String  id){

		return shuoShuoService.get(id);
	   }

	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  void  insert(ShuoShuo  shuoShuo){

		  shuoShuoService.save(shuoShuo);
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  void  update(ShuoShuo  shuoShuo){

		  shuoShuoService.update(shuoShuo);
	   }

	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  void  delete(String id){

		  shuoShuoService.delete(id);
	   }

}
