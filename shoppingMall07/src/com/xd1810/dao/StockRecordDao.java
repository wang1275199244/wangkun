package com.xd1810.dao;

import com.xd1810.model.StockRecord;

import java.util.List;

public interface StockRecordDao {
    int addStockRecord(StockRecord stockRecord);
    List<StockRecord> getAllStockRecords();
    //List<StockRecord> getCurrentStockRecord(int currentPage, int pageSize);
}
