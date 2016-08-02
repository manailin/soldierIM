package com.yl.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.domain.Member;
import com.yl.service.IMemberService;
import com.yl.service.imp.MemberServiceImpl;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;


	/*测试可用
	 * 实例：http://localhost/dem01/member/get.json?id=3
	 * */
	@RequestMapping(value = "get.json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> get(Long id) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("date", memberService.get(id));
		return data;
	}

	@RequestMapping(value = "insert.json", method = RequestMethod.POST)
	public void insert(Member member) {

		memberService.save(member);
	}

	@RequestMapping(value = "update.json", method = RequestMethod.POST)
	public void update(Member member) {

		memberService.update(member);
	}

	/*测试可用
	 * 实例：http://localhost/dem01/member/delete.json?id=3
	 * */
	@RequestMapping(value = "delete.json", method = RequestMethod.POST)
	public void delete(Long id) {

		memberService.delete(id);
	}

	@RequestMapping(value = "list.json", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(String id) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("date", memberService.findAllList());
		return data;

	}


	   @RequestMapping(value = "shuoShuolist.json", method = RequestMethod.POST)
			@ResponseBody
			public Map<String, Object> list(Long id) {
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("date", memberService.getShuoShuoList(id));
				return data;

			}
}
