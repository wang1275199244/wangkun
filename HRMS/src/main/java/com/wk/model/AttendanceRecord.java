package com.wk.model;

import java.io.Serializable;

public class AttendanceRecord implements Serializable {
    private Integer id;
    private String clockIn;//上班打卡时间
    private String clockOut;//下班打卡时间
    private String overTimeStart;//加班开始时间
    private String overTimeEnd;//加班结束时间
    private Integer empid;
    private Integer state;//考勤状态0.正常1.迟到2.早退3.旷工

    public AttendanceRecord() {
    }

    public AttendanceRecord(String clockIn, String clockOut, Integer empid, Integer state) {
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.empid = empid;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClockIn() {
        return clockIn;
    }

    public void setClockIn(String clockIn) {
        this.clockIn = clockIn;
    }

    public String getClockOut() {
        return clockOut;
    }

    public void setClockOut(String clockOut) {
        this.clockOut = clockOut;
    }

    public String getOverTimeStart() {
        return overTimeStart;
    }

    public void setOverTimeStart(String overTimeStart) {
        this.overTimeStart = overTimeStart;
    }

    public String getOverTimeEnd() {
        return overTimeEnd;
    }

    public void setOverTimeEnd(String overTimeEnd) {
        this.overTimeEnd = overTimeEnd;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "id=" + id +
                ", clockIn='" + clockIn + '\'' +
                ", clockOut='" + clockOut + '\'' +
                ", overTimeStart='" + overTimeStart + '\'' +
                ", overTimeEnd='" + overTimeEnd + '\'' +
                ", empid=" + empid +
                ", state=" + state +
                '}';
    }
}
