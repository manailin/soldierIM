package com.yl.domain;

import sun.security.util.BigInt;

/**资讯类别类
 * 
 * 
 * */
public class Article_Category extends BaseEntity{

	
	/**等级*/
	private int grede;
	
	/**排序*/
	private  int order;
	
	/**名称*/
	private String name;
	
	/**seo 关键字*/
	private String seo_keywords;
	
	/**seo 标题*/
	private String sel_title;
	
	/**seo 描述*/
	private String  seo_description;
	
	/**树路径*/
	private String  tree_path;
	
	/**父节点*/
	private BigInt parent;

	public int getGrede() {
		return grede;
	}

	public void setGrede(int grede) {
		this.grede = grede;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeo_keywords() {
		return seo_keywords;
	}

	public void setSeo_keywords(String seo_keywords) {
		this.seo_keywords = seo_keywords;
	}

	public String getSel_title() {
		return sel_title;
	}

	public void setSel_title(String sel_title) {
		this.sel_title = sel_title;
	}

	public String getSeo_description() {
		return seo_description;
	}

	public void setSeo_description(String seo_description) {
		this.seo_description = seo_description;
	}

	public String getTree_path() {
		return tree_path;
	}

	public void setTree_path(String tree_path) {
		this.tree_path = tree_path;
	}

	public BigInt getParent() {
		return parent;
	}

	public void setParent(BigInt parent) {
		this.parent = parent;
	}
	
	
	

	
	
	
}
