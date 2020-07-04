package com.so.demosboot.modules.db.dao;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.db.entity.JobInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobInfoDao extends BaseDao<JobInfo> {

}
