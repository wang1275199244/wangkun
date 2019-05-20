package com.xd1810.dao;

import com.xd1810.model.Stock;

import java.util.List;

public interface StockDao {
    int updateStock(Stock stock);
    List<Stock> getStockByGid(Integer gid);
    int addStock(Stock stock);
}
