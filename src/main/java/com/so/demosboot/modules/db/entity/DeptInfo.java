package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

import java.util.List;

/**
 * 部门信息Entity
 * @author admin
 * @version 2020-02-24
 */
public class DeptInfo extends BaseEntity<DeptInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String deptName;		// 部门名称
	private String remark;		// 备注
	private int deptSize;		//机构规格
	private String deptFundForm;		//机构经费形式
	private String pId;			//父机构Id
	private DeptInfo pDeptInfo;   //父机构
	
	public DeptInfo() {
		super();
	}

	public DeptInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=100, message="部门名称长度必须介于 1 和 100 之间")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@Length(min=0, max=40, message="备注长度必须介于 0 和 40 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getDeptSize() {
		return deptSize;
	}

	public void setDeptSize(int deptSize) {
		this.deptSize = deptSize;
	}

	public String getDeptFundForm() {
		return deptFundForm;
	}

	public void setDeptFundForm(String deptFundForm) {
		this.deptFundForm = deptFundForm;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public DeptInfo getpDeptInfo() {
		return pDeptInfo;
	}

	public void setpDeptInfo(DeptInfo pDeptInfo) {
		this.pDeptInfo = pDeptInfo;
	}

	@Override
	public String toString() {
		return "DeptInfo{" +
				"id='" + id + '\'' +
				", deptName='" + deptName + '\'' +
				", remark='" + remark + '\'' +
				", deptSize=" + deptSize +
				", deptFundForm='" + deptFundForm + '\'' +
				", pId='" + pId + '\'' +
				", pDeptInfo=" + pDeptInfo +
				'}';
	}
}