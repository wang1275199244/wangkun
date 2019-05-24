package com.wk.model;

import java.io.Serializable;

public class AttendanceRecord implements Serializable {
    private Integer id;
    private Integer empid;
    private String date;//日期
    private String clockIn;//上班打卡时间
    private String clockOut;//下班打卡时间
    private Integer attendanceTime;//正常出勤时长
    private Integer overtime;//加班时长
    private Integer state;//考勤状态0.正常1.迟到2.早退3.旷工-1.缺勤

    public AttendanceRecord() {
    }

    public AttendanceRecord(Integer empid, String date) {
        this.empid = empid;
        this.date = date;
    }

    public AttendanceRecord(Integer empid, String date, String clockIn, Integer state) {
        this(empid,date);
        this.clockIn = clockIn;
        this.state = state;
    }

    public AttendanceRecord(Integer empid, String date, String clockIn, String clockOut, Integer state) {
        this(empid,date,clockIn,state);
        this.clockOut = clockOut;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Integer attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public Integer getOvertime() {
        return overtime;
    }

    public void setOvertime(Integer overtime) {
        this.overtime = overtime;
    }

    public AttendanceRecord(Integer id, Integer empid, String date, String clockIn, String clockOut, Integer attendanceTime, Integer overtime, Integer state) {
        this.id = id;
        this.empid = empid;
        this.date = date;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.attendanceTime = attendanceTime;
        this.overtime = overtime;
        this.state = state;
    }

    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "id=" + id +
                ", empid=" + empid +
                ", date='" + date + '\'' +
                ", clockIn='" + clockIn + '\'' +
                ", clockOut='" + clockOut + '\'' +
                ", attendanceTime=" + attendanceTime +
                ", overtime=" + overtime +
                ", state=" + state +
                '}';
    }
}
