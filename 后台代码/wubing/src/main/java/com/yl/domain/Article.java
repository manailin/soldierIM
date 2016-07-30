package com.yl.domain;

import org.apache.ibatis.type.LongTypeHandler;

import sun.security.util.BigInt;

/**
 * 文章类
 * @author Administrator
 *
 */
public class Article extends BaseEntity{

	
	/**作者*/
	private String author;
	
	/**内容*/
	private String content;
	
	/**点击数*/
	private BigInt  hits;
	
	/**是否发布*/
	private boolean is_publication;
	
	/**是否置顶*/
	private boolean is_top;
	
	/**seo_keywords*/
	private String  seo_keywords;
	
	/**seo_description*/
	private String  seo_description;
	
	/**seo_title*/
	private String seo_title;
	
	/**文章类别*/
	private BigInt  article_Category;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigInt getHits() {
		return hits;
	}

	public void setHits(BigInt hits) {
		this.hits = hits;
	}

	public boolean isIs_publication() {
		return is_publication;
	}

	public void setIs_publication(boolean is_publication) {
		this.is_publication = is_publication;
	}

	public boolean isIs_top() {
		return is_top;
	}

	public void setIs_top(boolean is_top) {
		this.is_top = is_top;
	}

	public String getSeo_keywords() {
		return seo_keywords;
	}

	public void setSeo_keywords(String seo_keywords) {
		this.seo_keywords = seo_keywords;
	}

	public String getSeo_description() {
		return seo_description;
	}

	public void setSeo_description(String seo_description) {
		this.seo_description = seo_description;
	}

	public String getSeo_title() {
		return seo_title;
	}

	public void setSeo_title(String seo_title) {
		this.seo_title = seo_title;
	}

	public BigInt getArticle_Category() {
		return article_Category;
	}

	public void setArticle_Category(BigInt article_Category) {
		this.article_Category = article_Category;
	}
	
	
	
}
