package com.yl.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yl.dao.MemberDao;
import com.yl.domain.Member;
import com.yl.service.UserService;

@Service
public class UserServiceimp extends baseServiceimp<Member> implements UserService{

	@Autowired
	private MemberDao  memberMapper;

	public Member getUser(Long id) {
		// TODO Auto-generated method stub
		return memberMapper.getUser(id);
	}

	public Member getUserByName(String name) {
		// TODO Auto-generated method stub
		 return memberMapper.getUserByName(name);
	}

	public String login(String name, String password) {
		// TODO Auto-generated method stub
		Member member = memberMapper.getUserByName(name);
		if (member ==null) {
			return "";
		}
		if (member.getPassword().equals(password)) {
			
			return "success";
		} else {
        
		}
		return "false";
	}
	

}
