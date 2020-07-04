package com.so.demosboot.modules.db.service;

import org.springframework.stereotype.Service;

import com.so.demosboot.common.baseData.BaseService;
import com.so.demosboot.modules.db.dao.SalaryInfoDao;
import com.so.demosboot.modules.db.entity.SalaryInfo;

/**
 * 薪资信息Service
 * @author admin
 * @version V1.0
 */
@Service
public class SalaryInfoService extends BaseService<SalaryInfoDao, SalaryInfo> {

	public void add(SalaryInfo entity) {
		dao.insert(entity);
	}
}