package com.wk.model;

import java.io.Serializable;

public class AttendanceFand implements Serializable {
    private Employee employee;
    private AttendanceRecord attendanceRecord;

    public AttendanceFand() {
    }

    public AttendanceFand(Employee employee, AttendanceRecord attendanceRecord) {
        this.employee = employee;
        this.attendanceRecord = attendanceRecord;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AttendanceRecord getAttendanceRecord() {
        return attendanceRecord;
    }

    public void setAttendanceRecord(AttendanceRecord attendanceRecord) {
        this.attendanceRecord = attendanceRecord;
    }

    @Override
    public String toString() {
        return "AttendanceFand{" +
                "employee=" + employee +
                ", attendanceRecord=" + attendanceRecord +
                '}';
    }
}
