package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 薪资信息Entity
 * @author admin
 * @version 2020-02-24
 */
public class SalaryInfo extends BaseEntity<SalaryInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String staffId;		// 员工ID
	private String yearMon;		// 工资年月
	private Double truePrice;		// 实发工资
	private String remark;		// 备注
	
	public SalaryInfo() {
		super();
	}

	public SalaryInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="员工ID长度必须介于 1 和 40 之间")
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	@Length(min=1, max=40, message="工资年月长度必须介于 1 和 40 之间")
	public String getYearMon() {
		return yearMon;
	}

	public void setYearMon(String yearMon) {
		this.yearMon = yearMon;
	}
	
	@NotNull(message="实发工资不能为空")
	public Double getTruePrice() {
		return truePrice;
	}

	public void setTruePrice(Double truePrice) {
		this.truePrice = truePrice;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	private List<SalaryDetail> details;
	private String staffName;

	public List<SalaryDetail> getDetails() {
		return details;
	}

	public void setDetails(List<SalaryDetail> details) {
		this.details = details;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	
}