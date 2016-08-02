package com.yl.service.imp;

import java.util.List;

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

	public ShuoShuo get(ShuoShuo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public ShuoShuo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ShuoShuo get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(ShuoShuo entity) {
		// TODO Auto-generated method stub

	}

	public void delete(ShuoShuo entity) {
		// TODO Auto-generated method stub

	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public void update(ShuoShuo entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShuoShuo> findAllList() {
		// TODO Auto-generated method stub
		return null;
	}





}
