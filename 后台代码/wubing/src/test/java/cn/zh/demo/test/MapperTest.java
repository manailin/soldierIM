package cn.zh.demo.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yl.mapper.TestMapper;

public class MapperTest extends AbstractSpringTest {
	
	@Autowired
	TestMapper testMapper;
	@Autowired
	private DataSource dataSource;

	@Test
	public void testGetUser() throws Exception {
		System.out.println(testMapper.getUser(1L));
	}
}
