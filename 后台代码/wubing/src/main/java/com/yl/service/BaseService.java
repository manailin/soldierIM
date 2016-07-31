package com.yl.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yl.dao.BaseDao;
import com.yl.domain.BaseEntity;

/**
 * Service基类
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public interface BaseService { 	
	
	
}
