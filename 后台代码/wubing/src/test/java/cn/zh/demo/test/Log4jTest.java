package cn.zh.demo.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试日志打印器
 * @author zh
 * 
 * 1.获取日志打印的核心对象 logger
 * 2.调用打印方法打印不同级别的日志
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
		logger.debug("这是最简单的字符串打印");
	}
	
	@Test
	public void testLogInfo() throws Exception {
		logger.info("这是最简单的字符串打印");
	}
	
	@Test
	public void testLogError() throws Exception {
		logger.error("这是最简单的字符串打印");
	}
}
