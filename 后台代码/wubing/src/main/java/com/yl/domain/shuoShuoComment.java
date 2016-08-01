package com.yl.domain;

import sun.security.util.BigInt;

/**说说评论类
 * 
 * 
 * 
 * */
public class shuoShuoComment extends BaseEntity<shuoShuoComment>{

	
	/**说说ID*/
	private BigInt  ShuoShuo_id;
	
	/**会员ID*/
	private BigInt  member_id;
	
	/**说说评论父节点*/
	private BigInt  parent;
	
	/**发表的内容*/
	private String  content;

	public BigInt getShuoShuo_id() {
		return ShuoShuo_id;
	}

	public void setShuoShuo_id(BigInt shuoShuo_id) {
		ShuoShuo_id = shuoShuo_id;
	}

	public BigInt getMember_id() {
		return member_id;
	}

	public void setMember_id(BigInt member_id) {
		this.member_id = member_id;
	}

	public BigInt getParent() {
		return parent;
	}

	public void setParent(BigInt parent) {
		this.parent = parent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
