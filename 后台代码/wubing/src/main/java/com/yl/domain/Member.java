package com.yl.domain;

import java.util.Date;

import sun.security.util.BigInt;

public class Member extends BaseEntity<Member> {

	public enum Gender {

		/** 男 */
		Male,

		/** 女 */
		Female
	}

	/** 姓名 */
	private String name;

	/** 密码 */
	private String password;

	/** 邮箱 */
	private String email;

	/** 姓名 */
	private Gender gender;

	/** 出生时间 */
	private String birth;

	/** 手机号码 */
	private String mobile;

	/** 地区 */
	private BigInt area;

	/** 会员类别 */
	private int member_type;

	/** 会员头像 */
	private String pic;

	/** 粉丝数 */
	private BigInt fans;

	/** 关注度 */
	private BigInt focus;

	/** 帮助事件个数 */
	private BigInt help;

	/** 求助事件个数 */
	private BigInt needHelp;

	/** 积分 */
	private BigInt point;

	/** 账户是否被锁定 */
	private Boolean is_enable;

	/**锁定时间*/
	private Date  locked_date;

	/**失败次数*/
	private int login_False_Count;

	/**ip*/
	private String  ip;

	/**拓展字段1*/
	private String attribute_value0;

	/**拓展字段2*/
	private String attribute_value1;

	/**拓展字段3*/
	private String attribute_value2;

	/**拓展字段4*/
	private String attribute_value3;

	/**拓展字段4*/
	private String attribute_value4;

	private int del_flag;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public BigInt getArea() {
		return area;
	}

	public void setArea(BigInt area) {
		this.area = area;
	}

	public int getMember_type() {
		return member_type;
	}

	public void setMember_type(int member_type) {
		this.member_type = member_type;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public BigInt getFans() {
		return fans;
	}

	public void setFans(BigInt fans) {
		this.fans = fans;
	}

	public BigInt getFocus() {
		return focus;
	}

	public void setFocus(BigInt focus) {
		this.focus = focus;
	}

	public BigInt getHelp() {
		return help;
	}

	public void setHelp(BigInt help) {
		this.help = help;
	}

	public BigInt getNeedHelp() {
		return needHelp;
	}

	public void setNeedHelp(BigInt needHelp) {
		this.needHelp = needHelp;
	}

	public BigInt getPoint() {
		return point;
	}

	public void setPoint(BigInt point) {
		this.point = point;
	}

	public Boolean getIs_enable() {
		return is_enable;
	}

	public void setIs_enable(Boolean is_enable) {
		this.is_enable = is_enable;
	}

	public Date getLocked_date() {
		return locked_date;
	}

	public void setLocked_date(Date locked_date) {
		this.locked_date = locked_date;
	}

	public int getLogin_False_Count() {
		return login_False_Count;
	}

	public void setLogin_False_Count(int login_False_Count) {
		this.login_False_Count = login_False_Count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAttribute_value0() {
		return attribute_value0;
	}

	public void setAttribute_value0(String attribute_value0) {
		this.attribute_value0 = attribute_value0;
	}

	public String getAttribute_value1() {
		return attribute_value1;
	}

	public void setAttribute_value1(String attribute_value1) {
		this.attribute_value1 = attribute_value1;
	}

	public String getAttribute_value2() {
		return attribute_value2;
	}

	public void setAttribute_value2(String attribute_value2) {
		this.attribute_value2 = attribute_value2;
	}

	public String getAttribute_value3() {
		return attribute_value3;
	}

	public void setAttribute_value3(String attribute_value3) {
		this.attribute_value3 = attribute_value3;
	}

	public String getAttribute_value4() {
		return attribute_value4;
	}

	public void setAttribute_value4(String attribute_value4) {
		this.attribute_value4 = attribute_value4;
	}

	public int getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", password=" + password + ", email="
				+ email + ", gender=" + gender + ", birth=" + birth
				+ ", mobile=" + mobile + ", area=" + area + ", member_type="
				+ member_type + ", pic=" + pic + ", fans=" + fans + ", focus="
				+ focus + ", help=" + help + ", needHelp=" + needHelp
				+ ", point=" + point + ", is_enable=" + is_enable
				+ ", locked_date=" + locked_date + ", login_False_Count="
				+ login_False_Count + ", ip=" + ip + ", attribute_value0="
				+ attribute_value0 + ", attribute_value1=" + attribute_value1
				+ ", attribute_value2=" + attribute_value2
				+ ", attribute_value3=" + attribute_value3
				+ ", attribute_value4=" + attribute_value4 + ", del_flag="
				+ del_flag + "]";
	}


}
