package com.yl.dao.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yl.service.IMemberService;
import com.yl.service.imp.MemberServiceImpl;

public class UserSeriviceTest extends AbstractSpringTest {

	@Autowired
	MemberServiceImpl userService;
	@Autowired
	private DataSource dataSource;

	@Test
	public void testGetUser() throws Exception {
		System.out.println(userService.getUser(1L));
	}
}