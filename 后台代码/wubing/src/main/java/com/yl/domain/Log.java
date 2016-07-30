package com.yl.domain;

/**日志类
 * 
 * 
 * */
public class Log extends BaseEntity<Log>{

	
	/**内容*/
	private String content;
	
	/**ip*/
	private String ip;
	
	/**操作动作*/
	private String  operation;
	
	/**操作人*/
	private String openrator;
	
	/**操作参数*/
	private String parameter;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOpenrator() {
		return openrator;
	}

	public void setOpenrator(String openrator) {
		this.openrator = openrator;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	
	
	
	
}
