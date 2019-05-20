package com.xd1810.service;

import com.xd1810.model.Stock;

public interface StockService {
    boolean updateStock(Stock stock);
    Stock getStockByGid(Integer gid);
    boolean addStock(Stock stock);
}
