package com.xd1810.dao;

import com.xd1810.model.Orders;
import com.xd1810.model.User;

import java.util.List;

public interface OrdersDao {
    int addOrders(Orders orders);
    int delOrders(Orders orders);
    List<Orders> getOrdersByUid(Integer uid);
    List<Orders> getOrdersByUdid(Integer udid);
    Orders getOrdersById(Integer id);
    List<Orders> getOrdersByUidAndGidAndTime(Integer uid, Integer gid, String time);
    int updateOrders(Orders orders);
    List<Orders> getOrdersByUidAndStateDelivery(Integer uid, Integer state, Integer delivery);
    List<Orders> getOrdersByGid(Integer gid);
    List<Orders> getAllOrders();
    List<Orders> getOrdersByStateAndDelivery(Integer state, Integer delivery);
}
