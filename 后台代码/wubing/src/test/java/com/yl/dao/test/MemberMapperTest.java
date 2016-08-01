package com.yl.dao.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yl.dao.MemberMapper;

public class MemberMapperTest extends AbstractSpringTest {

	@Autowired
	MemberMapper testMapper;
	@Autowired
	private DataSource dataSource;

/*	@Test
	public void testGetUser() throws Exception {
		System.out.println(testMapper.getUser(1L));
	}*/
	@Test
	public void GetUser() throws Exception {
		System.out.println(testMapper.get(1L));
	}
}
