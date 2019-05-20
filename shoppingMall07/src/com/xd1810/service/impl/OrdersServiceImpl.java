package com.xd1810.service.impl;

import com.xd1810.dao.OrdersDao;
import com.xd1810.model.Orders;
import com.xd1810.model.User;
import com.xd1810.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    @Override
    public Integer addOrders(Orders orders) {
        if(orders == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = ordersDao.addOrders(orders);
        if(row != 0){
            List<Orders> list = ordersDao.getOrdersByUidAndGidAndTime(orders.getUid(), orders.getGid(), orders.getTime());
            if(list != null&&list.size() != 0){
                return list.get(0).getId();
            }
        }
        return null;
    }

    @Override
    public boolean delOrders(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        Orders orders = ordersDao.getOrdersById(id);
        int row = 0;
        if(orders != null){
            row = ordersDao.delOrders(orders);
            if(row != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Orders> getOrdersByUid(Integer uid) {
        if (uid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return ordersDao.getOrdersByUid(uid);
    }

    @Override
    public List<Orders> getOrdersByUdid(Integer udid) {
        if (udid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return ordersDao.getOrdersByUdid(udid);
    }

    @Override
    public List<Orders> getOrdersByUidAndStateDelivery(Integer uid, Integer state, Integer delivery) {
        if (uid == null||state == null||delivery == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return ordersDao.getOrdersByUidAndStateDelivery(uid,state,delivery);
    }

    @Override
    public Orders getOrdersById(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return ordersDao.getOrdersById(id);

    }

    @Override
    public Orders getOrdersByUidAndGidAndTime(Integer uid, Integer gid, String time) {
        if (uid == null||gid == null||time == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<Orders> list = ordersDao.getOrdersByUidAndGidAndTime(uid, gid, time);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean updateOrders(Orders orders) {
        if(orders == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = ordersDao.updateOrders(orders);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Orders> getOrdersByGid(Integer gid) {
        if(gid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return ordersDao.getOrdersByGid(gid);
    }

    @Override
    public List<Orders> getAllOrders() {
        return ordersDao.getAllOrders();
    }

    @Override
    public List<Orders> getOrdersByStateAndDelivery(Integer state, Integer delivery) {
        if(state == null||delivery == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return ordersDao.getOrdersByStateAndDelivery(state, delivery);
    }

}
