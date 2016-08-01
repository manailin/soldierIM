package com.yl.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yl.dao.AdminMapper;
import com.yl.dao.LogMapper;
import com.yl.dao.ShuoShuoCommentMapper;
import com.yl.domain.Log;
import com.yl.domain.Admin;
import com.yl.domain.shuoShuoComment;
import com.yl.service.IAdminService;
@Service
public class AdminServiceImpl implements IAdminService{


	@Autowired
	private AdminMapper  adminMapper;



	@Override
	public Admin get(Admin entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(Admin entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Admin entity) {
		// TODO Auto-generated method stub
		adminMapper.delete(entity);
	}

	@Override
	public void update(Admin entity) {
		// TODO Auto-generated method stub
		adminMapper.update(entity);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin get(Long id) {
		// TODO Auto-generated method stub
		return adminMapper.get(id);
	}

}
