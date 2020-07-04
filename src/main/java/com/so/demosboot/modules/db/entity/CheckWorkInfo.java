package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 考勤信息Entity
 * @author admin
 * @version 2020-02-24
 */
public class CheckWorkInfo extends BaseEntity<CheckWorkInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String staffId;		// 员工id
	private String kaoqingType;		// 考勤类型
	private String kaoqingTime;		// 考勤时间
	private String remark;		// 备注
	
	
	
	public CheckWorkInfo() {
		super();
	}

	public CheckWorkInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="员工id长度必须介于 1 和 40 之间")
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	@Length(min=1, max=20, message="考勤类型长度必须介于 1 和 20 之间")
	public String getKaoqingType() {
		return kaoqingType;
	}

	public void setKaoqingType(String kaoqingType) {
		this.kaoqingType = kaoqingType;
	}
	
	@Length(min=1, max=40, message="考勤时间长度必须介于 1 和 40 之间")
	public String getKaoqingTime() {
		return kaoqingTime;
	}

	public void setKaoqingTime(String kaoqingTime) {
		this.kaoqingTime = kaoqingTime;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	private String staffName;



	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	
}