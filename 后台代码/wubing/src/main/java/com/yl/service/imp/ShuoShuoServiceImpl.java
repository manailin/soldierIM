package com.yl.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yl.dao.BaseMapper;
import com.yl.dao.ShuoShuoMapper;
import com.yl.domain.BaseEntity;
import com.yl.domain.Member;
import com.yl.domain.ShuoShuo;
import com.yl.service.IShuoShuoService;
@Service
public class ShuoShuoServiceImpl implements IShuoShuoService{


	@Autowired
	private ShuoShuoMapper shuoShuoMapper;

	@Override
	public ShuoShuo get(ShuoShuo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShuoShuo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ShuoShuo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ShuoShuo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ShuoShuo entity) {
		// TODO Auto-generated method stub

	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShuoShuo get(Long id) {
		// TODO Auto-generated method stub
		return shuoShuoMapper.get(id);
	}



}
