package com.yl.domain;

import sun.security.util.BigInt;


/** 说说图片类
 * 发表说说中的图片
 * 可能一张图片可能多张图片
 * 
 * */
public class ShuoShuo_Picture extends BaseEntity{

	/**说说ID*/
	private BigInt  shuoshuo_id;
	
	/**图片优先级*/
	private  int   priority;
	
	/**图片路径*/
	private  String img_path;
	
	/**图片描述*/
	private  String  description;



	public BigInt getShuoshuo_id() {
		return shuoshuo_id;
	}

	public void setShuoshuo_id(BigInt shuoshuo_id) {
		this.shuoshuo_id = shuoshuo_id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
