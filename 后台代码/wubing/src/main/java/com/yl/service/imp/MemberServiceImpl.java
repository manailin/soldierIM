package com.yl.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yl.dao.LogMapper;
import com.yl.dao.MemberMapper;
import com.yl.dao.ShuoShuoCommentMapper;
import com.yl.domain.Log;
import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;
import com.yl.domain.shuoShuoComment;
import com.yl.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {

	@Autowired
	private MemberMapper memberMapper;

	public Member getUser(Long id) {
		// TODO Auto-generated method stub
		return memberMapper.getUser(id);
	}

	public List<Member> getUserByName(String name) {
		// TODO Auto-generated method stub
		return memberMapper.getUserByName(name);
	}

	public Map<String, Object> login(String name, String password) {
		Map<String, Object> data = new HashMap<String, Object>();

		// TODO Auto-generated method stub
		List<Member> memberList = memberMapper.getUserByName(name);
		if (name == null || password == null) {
			data.put("date", "帐号或 密码不能为空！");
		}
		if (memberList.size() < 1) {
			data.put("date", "帐号不存在！");
		} else if (memberList.get(0).getPassword().equals(password)) {
			data.put("date", "登录成功！");
		} else {

		}
		data.put("date", "帐号密码错误！");

		return data;
	}

	public Member get(Member entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Member get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Member get(Long id) {
		// TODO Auto-generated method stub
		return memberMapper.get(id);
	}

	public void save(Member entity) {
		// TODO Auto-generated method stub
		memberMapper.insert(entity);
	}

	public void delete(Member entity) {
		// TODO Auto-generated method stub
		memberMapper.delete(entity);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		memberMapper.deleteById(id);
	}

	public void update(Member entity) {
		// TODO Auto-generated method stub
		memberMapper.delete(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public List<Member> findAllList() {
		// TODO Auto-generated method stub
		return memberMapper.findAll();
	}

	public List<ShuoShuo> getShuoShuoList(Long id) {
		// TODO Auto-generated method stub
		return memberMapper.getShuoShuoList(id);
	}

}
