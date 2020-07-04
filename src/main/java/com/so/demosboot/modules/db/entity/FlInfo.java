package com.so.demosboot.modules.db.entity;

import org.hibernate.validator.constraints.Length;

import com.so.demosboot.common.baseData.BaseEntity;

/**
 * 部门信息Entity
 * @author admin
 * @version 2020-02-24
 */
public class FlInfo extends BaseEntity<FlInfo> {

    private static final long serialVersionUID = 1L;
    private String id;
    private String flName;		// 部门名称
    private String remark;		// 备注
    private String author;
    private String time;
    private String type;

    public FlInfo() {
        super();
    }

    public FlInfo(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    @Length(min=1, max=100, message="部门名称长度必须介于 1 和 100 之间")
    public String getFlName() {
        return flName;
    }

    public void setFlName(String flName) {
        this.flName = flName;
    }

    @Length(min=0, max=40, message="备注长度必须介于 0 和 40 之间")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Length(min=0, max=40, message="备注长度必须介于 0 和 40 之间")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Length(min=0, max=40, message="备注长度必须介于 0 和 40 之间")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Length(min=0, max=40, message="备注长度必须介于 0 和 40 之间")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}