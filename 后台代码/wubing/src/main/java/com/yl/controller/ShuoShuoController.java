package com.yl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;
import com.yl.service.IShuoShuoService;
import com.yl.service.imp.MemberServiceImpl;
import com.yl.service.imp.ShuoShuoServiceImpl;

@Controller
@RequestMapping("/shuoshuo")
public class ShuoShuoController {

	@Autowired
	private  ShuoShuoServiceImpl shuoShuoService;

	@Autowired
	private MemberServiceImpl memberService;


	@RequestMapping(value="/get",method= RequestMethod.GET)
	@ResponseBody
	   public  Map<String, Object>  get(Long  id){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("date", shuoShuoService.get(id));
		return data;
	   }

	   @RequestMapping(value="/insert",method= RequestMethod.POST)
	   public  void  insert(ShuoShuo  shuoShuo){

		  shuoShuoService.save(shuoShuo);
	   }

	   @RequestMapping(value="/update",method= RequestMethod.POST)
	   public  void  update(ShuoShuo  shuoShuo){

		  shuoShuoService.update(shuoShuo);
	   }

	   @RequestMapping(value="/delete",method= RequestMethod.POST)
	   public  void  delete(String id){

		  shuoShuoService.delete(id);
	   }

	   @RequestMapping(value = "list.json", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> list() {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("date", shuoShuoService.findAllList());
			return data;

		}

	   @RequestMapping(value = "commentlist.json", method = RequestMethod.POST)
			@ResponseBody
			public Map<String, Object> commentlist(Long shuoShuoID) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("date", shuoShuoService.findAllCommentList(shuoShuoID));
				return data;

			}

}
