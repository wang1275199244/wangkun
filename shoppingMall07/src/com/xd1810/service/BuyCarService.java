package com.xd1810.service;

import com.xd1810.model.BuyCar;

public interface BuyCarService {
    boolean addBuyCar(BuyCar buyCar);
    BuyCar getBuyCarById(Integer id);
    BuyCar getBuyCarByUid(Integer uid);
}
