package com.yl.service.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yl.dao.test.AbstractSpringTest;
import com.yl.service.IMemberService;
import com.yl.service.imp.MemberServiceImpl;
import com.yl.service.imp.ShuoShuoServiceImpl;

public class UserSeriviceTest extends AbstractSpringTest {

	@Autowired
	ShuoShuoServiceImpl ShuoShuoService;
	@Autowired
	private DataSource dataSource;

	@Test
	public void testGetUser() throws Exception {
		System.out.println(ShuoShuoService.get(1L));
	}
}