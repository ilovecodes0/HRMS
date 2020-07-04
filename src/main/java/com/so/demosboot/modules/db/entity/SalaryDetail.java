package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 薪资明细Entity
 * @author admin
 * @version 2020-02-24
 */
public class SalaryDetail extends BaseEntity<SalaryDetail> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String salaryId;		// 工资条ID
	private Double price;		// 金额
	private String name;		// 名称
	private String remark;		// 备注
	
	public SalaryDetail() {
		super();
	}

	public SalaryDetail(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="工资条ID长度必须介于 1 和 40 之间")
	public String getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}
	
	@NotNull(message="金额不能为空")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Length(min=1, max=40, message="名称长度必须介于 1 和 40 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="备注长度必须介于 0 和 200 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}