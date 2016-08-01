package com.yl.domain;

import sun.security.util.BigInt;

/**发表说说类
 *
 *
 */
public class ShuoShuo extends BaseEntity<ShuoShuo>{

	/**发表人*/
	private Member member_id;

	/**说说第一张图地址*/
	private String  imgurl;

	/**发表的说说内容*/
    private  String content;

    /**点击次数-浏览次数*/
    private  BigInt  hits;

    /**点赞次数*/
    private BigInt   likes;

	public Member getMember_id() {
		return member_id;
	}

	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getContent() {
		return content;
	}

	public void setContend(String content) {
		this.content = content;
	}

	public BigInt getHits() {
		return hits;
	}

	public void setHits(BigInt hits) {
		this.hits = hits;
	}

	public BigInt getLikes() {
		return likes;
	}

	public void setLikes(BigInt likes) {
		this.likes = likes;
	}









}
