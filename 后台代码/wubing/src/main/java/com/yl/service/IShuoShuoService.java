package com.yl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yl.dao.BaseMapper;
import com.yl.dao.ShuoShuoMapper;
import com.yl.domain.BaseEntity;
import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;

public interface IShuoShuoService extends BaseService<ShuoShuoMapper, ShuoShuo>{


	public List<ShuoShuo> getList(Long memberId);
}
