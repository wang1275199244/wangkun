package com.xd1810.dao;

import com.xd1810.model.Good;

import java.util.List;

public interface GoodDao {
    List<Good> getGoodsByState(Integer state);
    Good getGoodById(Integer id);
    //List<Good> getCurrentGood(int currentPage, int pageSize);
    //List<Good> getCurrentGoodForAdmin(int currentPage, int pageSize);
    List<Good> getAllGoods();
    int updateGood(Good good);
    int delGood(Good good);
    int addGood(Good good);
    List<Good> getGoods(Good good);
    List<Good> getGoodByLike(String searchComment);
}
