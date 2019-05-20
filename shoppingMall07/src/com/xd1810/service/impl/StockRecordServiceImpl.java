package com.xd1810.service.impl;

import com.xd1810.dao.StockRecordDao;
import com.xd1810.model.StockRecord;
import com.xd1810.service.StockRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stockRecordService")
public class StockRecordServiceImpl implements StockRecordService {
    @Resource
    private StockRecordDao stockRecordDao;

    @Override
    public boolean addStockRecord(StockRecord stockRecord) {
        if(stockRecord == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = stockRecordDao.addStockRecord(stockRecord);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public List<StockRecord> getAllStockRecords() {
        return stockRecordDao.getAllStockRecords();
    }

  /*  @Override
    public List<StockRecord> getCurrentStockRecord(int currentPage, int pageSize) {
        return stockRecordDao.getCurrentStockRecord(currentPage,pageSize);
    }*/
}
