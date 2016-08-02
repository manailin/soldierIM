package com.yl.dao;

import java.util.List;

import sun.security.util.BigInt;

import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;

public interface MemberMapper extends BaseMapper<Member>{

	public Member getUser(Long id);

	public List<Member> getUserByName(String name);

	void updatePasswordById(BigInt id, String password);

	boolean updateLoginInfo(String loginIp,String loginDate,BigInt id);

	public List<ShuoShuo> getShuoShuoList(Long id);
}
