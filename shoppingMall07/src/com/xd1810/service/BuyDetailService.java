package com.xd1810.service;

import com.xd1810.model.BuyDetail;

import java.util.List;

public interface BuyDetailService {
    boolean addBuyDetail(BuyDetail buyDetail);
    BuyDetail getBuyDetailByGid(Integer gid);
    boolean updateBuyDetail(BuyDetail buyDetal);
    List<BuyDetail> getBuyDetailByBcid(Integer bcid);
    boolean delBuyDetail(Integer id);
    BuyDetail getBuyDetail(BuyDetail buyDetail);
    BuyDetail getBuyDetailById(Integer id);
    //List<BuyDetail> getCurrentBuyDetailByBcid(int currentPage, int pageSize,Integer bcid);
}
