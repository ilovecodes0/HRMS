package com.so.demosboot.modules.db.entity;

import com.so.demosboot.common.baseData.BaseEntity;

import java.sql.Date;

public class CompileInfo extends BaseEntity<CompileInfo> {
    private String id;
    private String compileType;
    private String compileName;
    private String compileNumber;
    private Date compileTime;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getCompileType() {
        return compileType;
    }

    public void setCompileType(String compileType) {
        this.compileType = compileType;
    }

    public String getCompileName() {
        return compileName;
    }

    public void setCompileName(String compileName) {
        this.compileName = compileName;
    }

    public String getCompileNumber() {
        return compileNumber;
    }

    public void setCompileNumber(String compileNumber) {
        this.compileNumber = compileNumber;
    }

    public Date getCompileTime() {
        return compileTime;
    }

    public void setCompileTime(Date compileTime) {
        this.compileTime = compileTime;
    }

    @Override
    public String toString() {
        return "compileInfo{" +
                "id='" + id + '\'' +
                ", compileType='" + compileType + '\'' +
                ", compileName='" + compileName + '\'' +
                ", compileNumber='" + compileNumber + '\'' +
                ", compileTime=" + compileTime +
                '}';
    }
}
