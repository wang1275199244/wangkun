package com.xd1810.dao;

import com.xd1810.model.BuyCar;

import java.util.List;

public interface BuyCarDao {
    int addBuyCar(BuyCar buyCar);
    BuyCar getBuyCarById(Integer id);
    List<BuyCar> getBuyCarByUid(Integer uid);
}
