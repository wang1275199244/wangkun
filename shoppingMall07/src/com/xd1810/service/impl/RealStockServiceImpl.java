package com.xd1810.service.impl;

import com.xd1810.dao.RealStockDao;
import com.xd1810.model.RealStock;
import com.xd1810.service.RealStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("realStockService")
public class RealStockServiceImpl implements RealStockService {
    @Resource
    private RealStockDao realStockDao;

    @Override
    public boolean addRealStock(RealStock realStock) {
        if(realStock == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = realStockDao.addRealStock(realStock);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRealStock(RealStock realStock) {
        if(realStock == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = realStockDao.updateRealStock(realStock);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public RealStock getRealStockByGid(Integer gid) {
        if (gid == null||gid == 0){
            return null;
        }
        List<RealStock> list = realStockDao.getRealStockByGid(gid);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }
}
