package com.yl.service;

import com.yl.domain.User;

public interface UserService {

	User getUser(Long id);
	
	User getUserByName(String name);
	
	String  login(String name ,String password);
	
}
