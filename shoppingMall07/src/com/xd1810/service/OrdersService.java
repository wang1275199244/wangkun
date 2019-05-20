package com.xd1810.service;

import com.xd1810.model.Orders;
import com.xd1810.model.User;

import java.util.List;

public interface OrdersService {
    Integer addOrders(Orders orders);
    boolean delOrders(Integer id);
    List<Orders> getOrdersByUid(Integer uid);
    List<Orders> getOrdersByUdid(Integer udid);
    List<Orders> getOrdersByUidAndStateDelivery(Integer uid, Integer state, Integer delivery);
    Orders getOrdersById(Integer id);
    Orders getOrdersByUidAndGidAndTime(Integer uid, Integer gid, String time);
    boolean updateOrders(Orders orders);
    List<Orders> getOrdersByGid(Integer gid);
    List<Orders> getAllOrders();
    List<Orders> getOrdersByStateAndDelivery(Integer state, Integer delivery);

}
