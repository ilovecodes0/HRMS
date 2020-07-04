package com.so.demosboot.modules.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.db.entity.StaffInfo;

/**
 * 员工信息DAO接口
 * @author admin
 * @version V1.0
 */
@Mapper
public interface StaffInfoDao extends BaseDao<StaffInfo> {
	
}