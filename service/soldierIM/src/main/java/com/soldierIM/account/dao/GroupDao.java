package com.wowtour.account.dao;

import org.springframework.stereotype.Repository;

import com.wowtour.account.entity.Group;
import com.wowtour.common.dao.IMybatisDao;

/**
 * 
 * @author bear
 * @version 2015-07-15
 * @see com.wowtour.account.dao.Account
 */
@Repository
public interface GroupDao extends IMybatisDao<Group,Long>{
	public Long getOwnerbyGoupID(Long groupID);

    public void disableGroup(Long groupID);
    
    public String getGroupNameByID(Long groupID);
}