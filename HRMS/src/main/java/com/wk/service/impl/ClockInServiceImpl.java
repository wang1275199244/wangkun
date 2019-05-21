package com.wk.service.impl;

import com.wk.dao.ClockInDao;
import com.wk.model.ClockIn;
import com.wk.service.ClockInService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("clockInService")
public class ClockInServiceImpl implements ClockInService {
    @Resource
    private ClockInDao clockInDao;

    public boolean addClockIn(ClockIn clockIn) {
        if(clockIn == null){
            return false;
        }
        int row = clockInDao.addClockIn(clockIn);
        if(row != 0){
            return true;
        }
        return false;
    }
}
