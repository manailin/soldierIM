package com.yl.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yl.domain.User;
import com.yl.mapper.TestMapper;
import com.yl.service.UserService;

@Service
public class UserServiceimp implements UserService{

	@Autowired
	private TestMapper  mapper;

	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return mapper.getUser(id);
	}

	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		 return mapper.getUserByName(name);
	}

	public String login(String name, String password) {
		// TODO Auto-generated method stub
		User user = mapper.getUserByName(name);
		if (user ==null) {
			return "’À∫≈√‹¬Î¥ÌŒÛ";
		}
		if (user.getPasword().equals(password)) {
			
			return "success";
		} else {
        
		}
		return "false";
	}
	

}
