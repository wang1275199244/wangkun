package com.wk.service;

import com.wk.model.AttendanceRecord;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AttendanceRecordService {
    boolean addAttendanceRecord(AttendanceRecord attendanceRecord);
    boolean delAttendanceRecord(AttendanceRecord attendanceRecord);
    boolean updateAttendanceRecord(AttendanceRecord attendanceRecord);
    List<AttendanceRecord> getAttendanceRecordByEmpid(Integer empid);
    AttendanceRecord getAttendanceRecord(AttendanceRecord attendanceRecord);

}
