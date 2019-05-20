package com.xd1810.service.impl;

import com.xd1810.dao.BuyDetailDao;
import com.xd1810.model.BuyDetail;
import com.xd1810.service.BuyDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("buyDetailService")
public class BuyDetailServiceImpl implements BuyDetailService {
    @Resource
    private BuyDetailDao buyDetailDao;

    @Override
    public boolean addBuyDetail(BuyDetail buyDetail) {
        if(buyDetail == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = buyDetailDao.addBuyDetail(buyDetail);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public BuyDetail getBuyDetailByGid(Integer gid) {
        if(gid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<BuyDetail> list = buyDetailDao.getBuyDetailByGid(gid);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;

    }

    @Override
    public boolean updateBuyDetail(BuyDetail buyDetail) {
        if (buyDetail == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = buyDetailDao.updateBuyDetail(buyDetail);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public List<BuyDetail> getBuyDetailByBcid(Integer bcid) {
        if (bcid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return buyDetailDao.getBuyDetailByBcid(bcid);
    }

    @Override
    public boolean delBuyDetail(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        BuyDetail buyDetail1 = buyDetailDao.getBuyDetailById(id);
        int row = 0;
            if(buyDetail1 != null){
                 row = buyDetailDao.delBuyDetail(buyDetail1);
                if(row != 0){
                    return true;
                }
            }
        return false;
    }

    @Override
    public BuyDetail getBuyDetail(BuyDetail buyDetail) {
        if (buyDetail == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<BuyDetail> list = buyDetailDao.getBuyDetail(buyDetail);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public BuyDetail getBuyDetailById(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return buyDetailDao.getBuyDetailById(id);
    }

   /* @Override
    public List<BuyDetail> getCurrentBuyDetailByBcid(int currentPage, int pageSize, Integer bcid) {
        if (bcid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return buyDetailDao.getCurrentBuyDetailByBcid(currentPage,pageSize,bcid);
    }*/
}
