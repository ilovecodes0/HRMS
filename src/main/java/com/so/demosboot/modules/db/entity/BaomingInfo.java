package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

public class BaomingInfo extends BaseEntity<BaomingInfo>{
    private static final long serialVersionUID = 1L;
    public String id;
    public String staffName;		// 部门名称
    public String sex;
    public String nativePlace;
    public String homeAddress;
    public String phone;
    public String inTime;//预计入职时间
    public String workPost;//岗位
    public String statement;//个人陈述
    public String remarks;//反馈意见（报名者不填）
    public double mianshi;
    public double bishi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getWorkPost() {
        return workPost;
    }

    public void setWorkPost(String workPost) {
        this.workPost = workPost;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public double getMianshi() {
        return mianshi;
    }

    public void setMianshi(double mianshi) {
        this.mianshi = mianshi;
    }

    public double getBishi() {
        return bishi;
    }

    public void setBishi(double bishi) {
        this.bishi = bishi;
    }
}

