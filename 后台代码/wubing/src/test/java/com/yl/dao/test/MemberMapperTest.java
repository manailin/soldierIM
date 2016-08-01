package com.yl.dao.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yl.dao.MemberMapper;
import com.yl.domain.Member;

public class MemberMapperTest extends AbstractSpringTest {

	@Autowired
	MemberMapper testMapper;
	@Autowired
	private DataSource dataSource;

/*	@Test
	public void get() throws Exception {
		System.out.println(testMapper.get(1L).toString());
	}*/
	
/*	@Test
	public void update() throws Exception {
		Member member = testMapper.get(1L);
		member.setName("xiaowang");
		System.out.println(testMapper.update(member));
	}
	*/
	/*@Test
	public void delete() throws Exception {
		System.out.println(testMapper.get(1L).toString());
	}
	
	@Test
	public void insert() throws Exception {
		System.out.println(testMapper.get(1L).toString());
	}*/
}
