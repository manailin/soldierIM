package com.yl.dao;

import java.util.List;

import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;
import com.yl.domain.shuoShuoComment;

public interface ShuoShuoMapper extends BaseMapper<ShuoShuo>{


	public List<ShuoShuo> getList(Long memberId);

	public List<shuoShuoComment> findAllCommentList(Long shuoShuoID);




}
