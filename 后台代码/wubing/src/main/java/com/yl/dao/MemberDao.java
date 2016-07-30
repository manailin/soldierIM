package com.yl.dao;

import sun.security.util.BigInt;

import com.yl.domain.Member;

public interface MemberDao extends BaseDao<Member>{
	
	public Member getUser(Long id);
	
	public Member getUserByName(String name);
	
	void updatePasswordById(BigInt id, String password);
	
	boolean updateLoginInfo(String loginIp,String loginDate,BigInt id);
}
