package com.wk.service;

import com.wk.model.AttendanceRecord;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AttendanceRecordService {
    boolean addAttendanceRecord(AttendanceRecord attendanceRecord);
    boolean delAttendanceRecord(AttendanceRecord attendanceRecord);
    boolean updateAttendanceRecord(AttendanceRecord attendanceRecord);
    AttendanceRecord getAttendanceRecordByEmpidAndDate(AttendanceRecord attendanceRecord);
    List<AttendanceRecord> getAttendanceRecordByEmpid(Integer empid);
    List<AttendanceRecord> getAttendanceRecordByDate(String date);
}
