package com.xd1810.dao;

import com.xd1810.model.BuyDetail;

import java.util.List;

public interface BuyDetailDao {
    int addBuyDetail(BuyDetail buyDetail);
    int delBuyDetail(BuyDetail buyDetail);
    List<BuyDetail> getBuyDetailByGid(Integer gid);
    int updateBuyDetail(BuyDetail buyDetail);
    List<BuyDetail> getBuyDetailByBcid(Integer bcid);
    BuyDetail getBuyDetailById(Integer id);
    List<BuyDetail> getBuyDetail(BuyDetail buyDetail);
    //List<BuyDetail> getCurrentBuyDetailByBcid(int currentPage, int pageSize,Integer bcid);
}
