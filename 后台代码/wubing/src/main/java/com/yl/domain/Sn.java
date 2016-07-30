package com.yl.domain;

/**生成数字编号类
 * 
 * 
 * */
public class Sn extends BaseEntity{

	/**尾数值*/
	private String last_values;
	
	/**类型*/
	private String type;

	public String getLast_values() {
		return last_values;
	}

	public void setLast_values(String last_values) {
		this.last_values = last_values;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
