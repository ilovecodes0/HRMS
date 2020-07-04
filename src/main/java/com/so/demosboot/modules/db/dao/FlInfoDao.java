package com.so.demosboot.modules.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.db.entity.FlInfo;

/**
 * 部门信息DAO接口
 * @author admin
 * @version V1.0
 */
@Mapper
public interface FlInfoDao extends BaseDao<FlInfo> {

}