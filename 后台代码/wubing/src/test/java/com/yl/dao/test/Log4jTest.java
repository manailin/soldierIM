package com.yl.dao.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试日志打印�?
 * @author zh
 * 
 * 1.获取日志打印的核心对�?logger
 * 2.调用打印方法打印不同级别的日�?
 */
public class Log4jTest {
	
	private Logger logger;
	
	public Log4jTest() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@Test
	public void testGetLogger() throws Exception {
		System.out.println(logger.getClass());
	}
	
	@Test
	public void testLogDebug() throws Exception {
		logger.debug("测试打印");
	}
	
	@Test
	public void testLogInfo() throws Exception {
		logger.debug("测试打印");
	}
	
	@Test
	public void testLogError() throws Exception {
		logger.debug("测试打印");
	}
}
