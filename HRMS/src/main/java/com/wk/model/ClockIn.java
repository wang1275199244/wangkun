package com.wk.model;

import java.io.Serializable;

public class ClockIn implements Serializable {
    private Integer id;
    private Integer empid;
    private String date;
    private String time;
    private Integer state;//0.正常打卡1.旷工2.早退4.加班开始5.加班结束

    public ClockIn() {
    }

    public ClockIn(Integer empid, String date, String time, Integer state) {
        this.empid = empid;
        this.date = date;
        this.time = time;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ClockIn{" +
                "id=" + id +
                ", empid=" + empid +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", state=" + state +
                '}';
    }
}
