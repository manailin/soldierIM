package com.yl.service;

import com.yl.domain.Member;

public interface UserService {

	Member getUser(Long id);
	
	Member getUserByName(String name);
	
	String  login(String name ,String password);
	
}
