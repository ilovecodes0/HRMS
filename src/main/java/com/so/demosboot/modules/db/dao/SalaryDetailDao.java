package com.so.demosboot.modules.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.db.entity.SalaryDetail;

/**
 * 薪资明细DAO接口
 * @author admin
 * @version V1.0
 */
@Mapper
public interface SalaryDetailDao extends BaseDao<SalaryDetail> {
	
}