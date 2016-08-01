package com.yl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.yl.dao.LogDao;
import com.yl.dao.MemberDao;
import com.yl.dao.ShuoShuoCommentDao;
import com.yl.domain.Log;
import com.yl.domain.Member;
import com.yl.domain.shuoShuoComment;

public class MemberService extends EntityService<MemberDao, Member>{


	@Autowired
	private MemberDao  memberMapper;

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

}
