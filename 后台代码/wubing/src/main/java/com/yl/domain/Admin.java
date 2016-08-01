package com.yl.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import sun.security.util.BigInt;

public class Admin extends BaseEntity<Admin> {

	  /** 用户名 */
    private String            username;

    /** 密码 */
    private String            password;

    /** E-mail */
    private String            email;

    /** 姓名 */
    private String            name;

    /** 部门 */
    private String            department;

    /** 微信头像  */
    private String            weixinPic;

    /** 是否启用 */
    private Boolean           isEnabled;

    /** 是否锁定 */
    private Boolean           isLocked;

    /** 连续登录失败次数 */
    private Integer           loginFailureCount;

    /** 锁定日期 */
    private Date              lockedDate;

    /** 最后登录日期 */
    private Date              loginDate;

    /** 最后登录IP */
    private String            loginIp;

    /** 角色 */
    private Set<Role>         roles            = new HashSet<Role>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWeixinPic() {
		return weixinPic;
	}

	public void setWeixinPic(String weixinPic) {
		this.weixinPic = weixinPic;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	public Date getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
    
    
	
}
