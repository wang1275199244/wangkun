package com.xd1810.service.impl;

import com.xd1810.dao.BuyCarDao;
import com.xd1810.model.BuyCar;
import com.xd1810.service.BuyCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("buyCarService")
public class BuyCarServiceImpl implements BuyCarService {
    @Resource
    private BuyCarDao buyCarDao;

    @Override
    public boolean addBuyCar(BuyCar buyCar) {
        if(buyCar == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = buyCarDao.addBuyCar(buyCar);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public BuyCar getBuyCarById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return buyCarDao.getBuyCarById(id);
    }

    @Override
    public BuyCar getBuyCarByUid(Integer uid) {
        if(uid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<BuyCar> list =  buyCarDao.getBuyCarByUid(uid);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }

}
