package com.yl.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yl.dao.LogMapper;
import com.yl.dao.MemberMapper;
import com.yl.dao.ShuoShuoCommentMapper;
import com.yl.domain.Log;
import com.yl.domain.Member;
import com.yl.domain.shuoShuoComment;
import com.yl.service.IMemberService;
@Service
public class MemberServiceImpl implements IMemberService{


	@Autowired
	private MemberMapper  memberMapper;

	public Member getUser(Long id) {
		// TODO Auto-generated method stub
		return memberMapper.getUser(id);
	}

	public Member getUserByName(String name) {
		// TODO Auto-generated method stub
		 return (Member) memberMapper.getUserByName(name);
	}

	public String login(String name, String password) {
		// TODO Auto-generated method stub
		Member member = (Member) memberMapper.getUserByName(name);
		if (name ==null || password ==null) {
			return "帐号或 密码不能为空！";
		}
		if (memberMapper.getUserByName(name).size()<1 ) {
			return "帐号不存在！";
		}
		if (member.getPassword().equals(password)) {

			return "success";
		} else {

		}
		return "帐号密码错误";
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

	@Override
	public List<Member> findAllList() {
		// TODO Auto-generated method stub
		return memberMapper.findAll();
	}



}
