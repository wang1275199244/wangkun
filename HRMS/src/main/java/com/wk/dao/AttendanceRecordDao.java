package com.wk.dao;

import com.wk.model.AttendanceRecord;

import java.util.List;

public interface AttendanceRecordDao {
    int addAttendanceRecord(AttendanceRecord attendanceRecord);
    int delAttendanceRecord(AttendanceRecord attendanceRecord);
    int updateAttendanceRecord(AttendanceRecord attendanceRecord);
    List<AttendanceRecord> getAttendanceRecordByEmpid(Integer empid);

}
