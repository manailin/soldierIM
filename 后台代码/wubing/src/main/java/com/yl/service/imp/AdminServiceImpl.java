package com.yl.service.imp;

import java.util.List;

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

	public Admin get() {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save() {
		// TODO Auto-generated method stub

	}

	public void delete() {
		// TODO Auto-generated method stub

	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Admin> findAllList() {
		// TODO Auto-generated method stub
		return null;
	}

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

	}

	@Override
	public void update(Admin entity) {
		// TODO Auto-generated method stub

	}




}
