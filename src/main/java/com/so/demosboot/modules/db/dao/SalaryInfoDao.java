package com.so.demosboot.modules.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.db.entity.SalaryInfo;

/**
 * 薪资信息DAO接口
 * @author admin
 * @version V1.0
 */
@Mapper
public interface SalaryInfoDao extends BaseDao<SalaryInfo> {
	
}