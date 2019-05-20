package com.xd1810.service;

import com.xd1810.model.Good;

import java.util.List;

public interface GoodService {
    List<Good> getGoodsByState(Integer state);
    Good getGoodById(Integer id);
    //List<Good> getCurrentGood(int currentPage, int pageSize);
    //List<Good> getCurrentGoodForAdmin(int currentPage, int pageSize);
    List<Good> getAllGoods();
    boolean updateGoodByIdAndState(Integer id, Integer state);
    boolean delGood(Integer id);
    boolean addGood(Good good);
    Good getGoods(Good good);
    List<Good> getGoodByLike(String searchComment);
}
