package com.so.demosboot.modules.db.entity;

import com.so.demosboot.common.baseData.BaseEntity;


public class JobInfo extends BaseEntity<JobInfo> {
    private String id;
    private String jobName;
    private String deptId;
    private DeptInfo deptInfo;
    private String compileId;
    private CompileInfo compileInfo;
    private String jobTime;

    public JobInfo(){
        super();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public DeptInfo getDeptInfo() {
        return deptInfo;
    }

    public void setDeptInfo(DeptInfo deptInfo) {
        this.deptInfo = deptInfo;
    }

    public String getCompileId() {
        return compileId;
    }

    public void setCompileId(String compileId) {
        this.compileId = compileId;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public CompileInfo getCompileInfo() {
        return compileInfo;
    }

    public void setCompileInfo(CompileInfo compileInfo) {
        this.compileInfo = compileInfo;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "id='" + id + '\'' +
                ", jobName='" + jobName + '\'' +
                ", deptId='" + deptId + '\'' +
                ", deptInfo=" + deptInfo +
                ", compileId='" + compileId + '\'' +
                ", compileInfo=" + compileInfo +
                ", jobTime=" + jobTime +
                '}';
    }
}
