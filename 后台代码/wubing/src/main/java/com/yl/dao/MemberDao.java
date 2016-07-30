package com.yl.dao;

import com.yl.domain.Member;

public interface MemberDao extends BaseDao<Member>{
	
	public Member getUser(Long id);
	
	public Member getUserByName(String name);
}
