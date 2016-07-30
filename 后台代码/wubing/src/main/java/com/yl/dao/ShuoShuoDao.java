package com.yl.dao;

import java.util.List;

import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;

public interface ShuoShuoDao extends BaseDao<ShuoShuo>{
	
	public Member get(Long id);
	
	public List<ShuoShuo> getList(Member Member);

	

	
}
