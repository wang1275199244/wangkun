package com.xd1810.service.impl;

import com.xd1810.dao.GoodDao;
import com.xd1810.model.Good;
import com.xd1810.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodService")
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodDao goodDao;

    @Override
    public List<Good> getGoodsByState(Integer state) {
        if(state == null) {
            throw new IllegalArgumentException("入参不合法");
        }
        return goodDao.getGoodsByState(state);
    }

    @Override
    public Good getGoodById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return goodDao.getGoodById(id);
    }

   /* @Override
    public List<Good> getCurrentGood(int currentPage, int pageSize) {
        return goodDao.getCurrentGood(currentPage,pageSize);
    }*/

    /*@Override
    public List<Good> getCurrentGoodForAdmin(int currentPage, int pageSize) {
        return goodDao.getCurrentGoodForAdmin(currentPage,pageSize);
    }*/

    @Override
    public List<Good> getAllGoods() {
        return goodDao.getAllGoods();
    }

    @Override
    public boolean updateGoodByIdAndState(Integer id, Integer state) {
        if(id == null||state == null) {
            throw new IllegalArgumentException("入参不合法");
        }
        Good good = goodDao.getGoodById(id);
        int row = 0;
        if(good != null){
            good.setState(state);
            row =  goodDao.updateGood(good);
            if(row != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delGood(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        Good good = goodDao.getGoodById(id);
        int row = 0;
        if(good != null){
            row =  goodDao.delGood(good);
            if(row != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addGood(Good good) {
        if(good == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = goodDao.addGood(good);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public Good getGoods(Good good) {
        if(good == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<Good> list = goodDao.getGoods(good);
            if(list != null&&list.size() != 0){
                return list.get(0);
            }
        return null;
    }

    @Override
    public List<Good> getGoodByLike(String searchComment) {
        if(searchComment == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return goodDao.getGoodByLike(searchComment);
    }
}
