package com.yl.demo.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.yl.service.UserService;

public class UserSeriviceTest extends AbstractSpringTest {
	
	@Autowired
	UserService userService;
	@Autowired
	private DataSource dataSource;

	@Test
	public void testGetUser() throws Exception {
		System.out.println(userService.getUser(1L));
	}
}