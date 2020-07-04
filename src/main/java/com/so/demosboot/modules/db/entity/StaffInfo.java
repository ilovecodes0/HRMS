package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 员工信息Entity
 * @author admin
 * @version 2020-02-24
 */
public class StaffInfo extends BaseEntity<StaffInfo> {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String deptId;		// 部门ID
	private String staffName;		// 员工姓名
	private String sex;		// 性别
	private String cardNo;		// 身份证号
	private String nativePlace;		// 籍贯
	private String homeAddress;		// 家庭住址
	private String phone;		// 联系电话
	private String workYears;		// 工作年限
	private String inTime;		// 入职时间
	private String workPost;		// 工作岗位
	private Double baseSalary;		// 基本工资
	private String status;		// 员工状态
	private String outTime;		// 离职时间



	private String jobId;      //工号
	private String degree;		//文化程度
	private String level;		//技术等级
	private String post;		//职务
	private String techTitle;		//职称

	
	public StaffInfo() {
		super();
	}

	public StaffInfo(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	

	@Length(min=1, max=40, message="部门ID长度必须介于 1 和 40 之间")
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	@Length(min=1, max=40, message="员工姓名长度必须介于 1 和 40 之间")
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	@Length(min=1, max=20, message="性别长度必须介于 1 和 20 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=40, message="身份证号长度必须介于 1 和 40 之间")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	@Length(min=1, max=40, message="籍贯长度必须介于 1 和 40 之间")
	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	@Length(min=0, max=200, message="家庭住址长度必须介于 0 和 200 之间")
	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	@Length(min=1, max=30, message="联系电话长度必须介于 1 和 30 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=10, message="工作年限长度必须介于 0 和 10 之间")
	public String getWorkYears() {
		return workYears;
	}

	public void setWorkYears(String workYears) {
		this.workYears = workYears;
	}
	
	@Length(min=0, max=40, message="入职时间长度必须介于 0 和 40 之间")
	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	@Length(min=0, max=50, message="工作岗位长度必须介于 0 和 50 之间")
	public String getWorkPost() {
		return workPost;
	}

	public void setWorkPost(String workPost) {
		this.workPost = workPost;
	}
	
	@NotNull(message="基本工资不能为空")
	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	@Length(min=1, max=20, message="员工状态长度必须介于 1 和 20 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=0, max=40, message="离职时间长度必须介于 0 和 40 之间")
	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTechTitle() {
		return techTitle;
	}

	public void setTechTitle(String techTitle) {
		this.techTitle = techTitle;
	}

	private String deptName;
	private Double changePrice;//调整工资接收字段
	private String changeRemark;//调整说明


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Double getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(Double changePrice) {
		this.changePrice = changePrice;
	}

	public String getChangeRemark() {
		return changeRemark;
	}

	public void setChangeRemark(String changeRemark) {
		this.changeRemark = changeRemark;
	}

	@Override
	public String getRemarks() {
		return remarks;
	}

	@Override
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "StaffInfo{" +
				"staffName='" + staffName + '\'' +
				", sex='" + sex + '\'' +
				", deptName='" + deptName + '\'' +
				", jobId='" + jobId + '\'' +
				", cardNo='" + cardNo + '\'' +
				", nativePlace='" + nativePlace + '\'' +
				", homeAddress='" + homeAddress + '\'' +
				", phone='" + phone + '\'' +
				", workYears='" + workYears + '\'' +
				", inTime='" + inTime + '\'' +
				", workPost='" + workPost + '\'' +
				", baseSalary=" + baseSalary +
				", status='" + status + '\'' +
				", degree='" + degree + '\'' +
				", level='" + level + '\'' +
				", post='" + post + '\'' +
				", techTitle='" + techTitle + '\'' +
				'}';
	}
}