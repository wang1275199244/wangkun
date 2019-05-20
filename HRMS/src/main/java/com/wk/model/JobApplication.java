package com.wk.model;

import java.io.Serializable;

public class JobApplication implements Serializable {
    private Integer id;
    private Integer riid;
    private Integer rid;
    private String date;//投递简历日期
    private Integer state;//0.提出申请/1.管理员已查看/2.管理员查看后发出面试邀请/3.拒绝面试邀请/4.接受面试邀请/5.没有面试成功/6.面试成功成为员工

    public JobApplication() {
    }

    public JobApplication(Integer riid, Integer rid, String date, Integer state) {
        this.riid = riid;
        this.rid = rid;
        this.date = date;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRiid() {
        return riid;
    }

    public void setRiid(Integer riid) {
        this.riid = riid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", riid=" + riid +
                ", rid=" + rid +
                ", date='" + date + '\'' +
                ", state=" + state +
                '}';
    }
}
