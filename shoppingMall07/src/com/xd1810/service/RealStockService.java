package com.xd1810.service;

import com.xd1810.model.RealStock;

public interface RealStockService {
    boolean addRealStock(RealStock realStock);
    boolean updateRealStock(RealStock realStock);
    RealStock getRealStockByGid(Integer gid);
}
