package com.so.demosboot.modules.sys.dao;

import com.so.demosboot.common.baseData.BaseDao;
import com.so.demosboot.modules.sys.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统通知DAO接口
 * @author so
 * @version V1.0
 */
@Mapper
public interface NoticeDao extends BaseDao<Notice> {
	
}