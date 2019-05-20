package com.xd1810.service.impl;

import com.xd1810.dao.StockDao;
import com.xd1810.model.Stock;
import com.xd1810.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("stockService")
public class StockServiceImpl implements StockService {
    @Resource
    private StockDao stockDao;

    @Override
    public boolean updateStock(Stock stock) {
        if(stock == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = stockDao.updateStock(stock);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public Stock getStockByGid(Integer gid) {
        if(gid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<Stock> list = stockDao.getStockByGid(gid);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean addStock(Stock stock) {
        if(stock == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = stockDao.addStock(stock);
        if(row != 0){
            return true;
        }
        return false;
    }
}
