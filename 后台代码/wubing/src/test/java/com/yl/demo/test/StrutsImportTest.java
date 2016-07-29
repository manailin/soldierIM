package com.yl.demo.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StrutsImportTest extends AbstractSpringTest {
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testDataSource() throws Exception {
		System.out.println(dataSource);
		Connection connection = dataSource.getConnection();
		String sql = "select * from t_user";
		// 创建预处理语�?
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		// 执行查询语句
		ResultSet resultSet = prepareStatement.executeQuery();
		// 获取查询的结�?
		while(resultSet.next()){
			System.out.println("id : " + resultSet.getLong(1));
			System.out.println("name : " + resultSet.getString(2));
		}
		//释放资源   -- �?��在finally�?
		resultSet.close();
		connection.close();
	}
}
