package com.wk.dao;

import com.wk.model.AttendanceRecord;
import com.wk.model.ClockIn;

import java.util.List;

public interface AttendanceRecordDao {
    int addAttendanceRecord(AttendanceRecord attendanceRecord);
    int delAttendanceRecord(AttendanceRecord attendanceRecord);
    int updateAttendanceRecord(AttendanceRecord attendanceRecord);
    AttendanceRecord getAttendanceRecordByEmpidAndDate(AttendanceRecord attendanceRecord);
    List<AttendanceRecord> getAttendanceRecordByEmpid(Integer empid);
    List<AttendanceRecord> getAttendanceRecordByDate(String date);

}
