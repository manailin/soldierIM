package com.yl.dao;

import java.util.List;

import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;

public interface ShuoShuoMapper extends BaseMapper<ShuoShuo>{


	public List<ShuoShuo> getList(Member Member);




}
