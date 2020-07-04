package com.so.demosboot.modules.db.entity;

import com.so.demosboot.common.baseData.BaseEntity;

public class ModelInfo extends BaseEntity<ModelInfo>{
    private String id;  //模板id
    private String mname;  //模板名称
    private String age;    //是否需要年龄
    private String num;    //是否需要工号
    private String name;   //是否需要名字
    private String gender; //是否需要性别
    private String telnum; //是否需要电话

    public ModelInfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    @Override
    public String toString() {
        return "ModelInfo{" +
                "id='" + id + '\'' +
                ", mname='" + mname + '\'' +
                ", age='" + age + '\'' +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", telnum='" + telnum + '\'' +
                '}';
    }
}
