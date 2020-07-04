package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 部门信息Entity
 * @author admin
 * @version 2020-02-24
 */
public class ZhaopinInfo extends BaseEntity<ZhaopinInfo> {
    public String toString(){
        return id+title+info+tTime+deptName+job+peopleNeed;
    }
    private static final long serialVersionUID = 1L;
    public String id;
    public String title;		// 部门名称
    public String info;		// 备注
    public String tTime;        //时间
    public String deptName;
    public String job;
    public int peopleNeed;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Length(min=1, max=40, message="长度必须介于 1 和 40 之间")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Length(min=1, max=500, message="长度必须介于 1 和 500 之间")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Length(min=1, max=40, message="长度必须介于 1 和 40 之间")
    public String getT_ime() {
        return tTime;
    }

    public void setT_time(String tTime) {
        this.tTime = tTime;
    }

    public String getDept_name() {
        return deptName;
    }

    public void setDept_name(String deptName) {
        this.deptName = deptName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getPeople_need() {
        return peopleNeed;
    }

    public void setPeople_need(int peopleNeed) {
        this.peopleNeed = peopleNeed;
    }
}