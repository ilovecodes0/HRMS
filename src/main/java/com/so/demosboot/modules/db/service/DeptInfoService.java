package com.so.demosboot.modules.db.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.so.demosboot.common.baseData.BaseService;
import com.so.demosboot.modules.db.dao.DeptInfoDao;
import com.so.demosboot.modules.db.entity.DeptInfo;

import java.util.Map;

/**
 * 部门信息Service
 * @author admin
 * @version V1.0
 */
@Service
public class DeptInfoService extends BaseService<DeptInfoDao, DeptInfo>{



}