package com.xd1810.service;

import com.xd1810.model.StockRecord;

import java.util.List;

public interface StockRecordService {
    boolean addStockRecord(StockRecord stockRecord);
    List<StockRecord> getAllStockRecords();
    //List<StockRecord> getCurrentStockRecord(int currentPage, int pageSize);
}
