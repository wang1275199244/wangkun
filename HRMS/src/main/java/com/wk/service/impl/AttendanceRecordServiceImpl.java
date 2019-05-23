package com.wk.service.impl;

import com.wk.dao.AttendanceRecordDao;
import com.wk.model.AttendanceRecord;
import com.wk.service.AttendanceRecordService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("attendanceRecordService")
public class AttendanceRecordServiceImpl implements AttendanceRecordService {
    @Resource
    private AttendanceRecordDao arDao;

    public boolean addAttendanceRecord(AttendanceRecord attendanceRecord) {
        if(attendanceRecord == null){
            return false;
        }
        int row = arDao.addAttendanceRecord(attendanceRecord);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delAttendanceRecord(AttendanceRecord attendanceRecord) {
        if(attendanceRecord == null){
            return false;
        }
        int row = arDao.delAttendanceRecord(attendanceRecord);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateAttendanceRecord(AttendanceRecord attendanceRecord) {
        if(attendanceRecord == null){
            return false;
        }
        int row = arDao.updateAttendanceRecord(attendanceRecord);
        if(row != 0){
            return true;
        }
        return false;
    }

    public List<AttendanceRecord> getAttendanceRecordByEmpid(Integer empid) {
        if(empid == null||empid == 0){
            return null;
        }
        return arDao.getAttendanceRecordByEmpid(empid);
    }

    public AttendanceRecord getAttendanceRecord(AttendanceRecord attendanceRecord) {
        if(attendanceRecord == null){
            return null;
        }
        return arDao.getAttendanceRecord(attendanceRecord);
    }
}
