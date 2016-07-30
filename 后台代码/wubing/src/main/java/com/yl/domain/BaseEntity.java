package com.yl.domain;

import java.util.Date;

import sun.security.util.BigInt;

/**
 * 基类
 * @author man
 *
 */
public class BaseEntity<T> {

	/**ID*/
	private BigInt id;
	
	/**创建时间*/
	private Date create_Date;
	
	/**修改时间*/
	private Date modify_Date;
	
	
	public BigInt getId() {
		return id;
	}
	public void setId(BigInt id) {
		this.id = id;
	}
	public Date getCreate_Date() {
		return create_Date;
	}
	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}
	public Date getModify_Date() {
		return modify_Date;
	}
	public void setModify_Date(Date modify_Date) {
		this.modify_Date = modify_Date;
	}
	
	
	
	
	
	
}
