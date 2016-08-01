package com.yl.dao.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yl.dao.ShuoShuoMapper;

public class ShuoShuoMapperTest extends AbstractSpringTest {

	@Autowired
	ShuoShuoMapper ShuoShuoMapper;
	@Autowired
	private DataSource dataSource;


	@Test
	public void GetShuoShuo() throws Exception {
		System.out.println(ShuoShuoMapper.get(1L));
	}
}
