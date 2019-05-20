package com.xd1810.dao;

import com.xd1810.model.RealStock;

import java.util.List;

public interface RealStockDao {
    int addRealStock(RealStock realStock);
    int updateRealStock(RealStock realStock);
    List<RealStock> getRealStockByGid(Integer gid);
}
