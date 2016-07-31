package com.yl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.ShuoShuo;
import com.yl.service.shuoShuoService;
import com.yl.service.ShuoShuoService;

@Controller
@RequestMapping("/shuoshuo")
public class ShuoShuoController {

	@Autowired
	private  ShuoShuoService shuoShuoService;
	
	@RequestMapping(value="get",method= RequestMethod.GET)
	   public  ShuoShuo  get(Long  id){
		   
		return shuoShuoService.get(id);	   
	   }
	   
	   @RequestMapping(value="insert",method= RequestMethod.POST)
	   public  Boolean  insert(ShuoShuo  shuoShuo){
		   
		 return shuoShuoService.save(shuoShuo);	   
	   }

	   @RequestMapping(value="update",method= RequestMethod.POST)
	   public  Boolean  update(ShuoShuo  shuoShuo){
		   
		 return shuoShuoService.update(shuoShuo);	   
	   }
	   
	   @RequestMapping(value="delete",method= RequestMethod.POST)
	   public  Boolean  delete(Long id){
		   
		 return shuoShuoService.delete(id);	   
	   }

}
