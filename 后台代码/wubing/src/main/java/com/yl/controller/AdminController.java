package com.yl.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Admin;
import com.yl.service.IAdminService;
import com.yl.service.imp.AdminServiceImpl;
import com.yl.service.imp.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private  AdminServiceImpl adminService;

   @RequestMapping(value="/get",method= RequestMethod.GET)
   public  Admin  get(String  id){

	return adminService.get(id);
   }

   @RequestMapping(value="/insert",method= RequestMethod.POST)
   public  void  insert(Admin  Admin){

	   adminService.save(Admin);
   }

   @RequestMapping(value="/update",method= RequestMethod.POST)
   public  void  update(Admin  Admin){

	   adminService.update(Admin);
   }

   @RequestMapping(value="/delete",method= RequestMethod.POST)
   public  void  delete(String id){

	   adminService.delete(id);
   }
   @RequestMapping(value = "list.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(String id) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("date", adminService.findAllList());
		return data;

	}
}
