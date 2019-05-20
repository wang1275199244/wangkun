package com.xd1810.controller;

import com.xd1810.model.*;
import com.xd1810.service.*;
import com.xd1810.utils.GetTotalPage;
import com.xd1810.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrdersController {
    @Resource
    private GoodService goodService;
    @Resource
    private UserService userService;
    @Resource
    private OrdersService ordersService;
    @Resource
    private UserDetailService userDetailService;
    @Resource
    private StockService stockService;

    @RequestMapping("createOrdersInformation")
    protected String createOrdersInformation(@RequestParam(name = "id",required = false)Integer id, @RequestParam(name = "gcount",required = false)Integer gcount, HttpServletRequest request,HttpSession session) throws Exception {
        Object user = session.getAttribute("user");
        User user1 = (User) user;
        if (user1 == null) {//没有登陆
            return "login";
        } else {//已经登录
            Good good = goodService.getGoodById(id);
            request.setAttribute("gd", good);
            session.setAttribute("got", gcount);
            User user2 = userService.getUserById(user1.getId());
            List<UserDetail> userDetails = userDetailService.getUserDetailByUid(user2.getId());
            session.setAttribute("udls", userDetails);
            return "createOrdersInformsation";
        }
    }

    @RequestMapping("addOrders")
    protected String addOrders (@RequestParam(name = "gid",required = false)Integer gid,@RequestParam(name = "udid",required = false)Integer udid, @RequestParam(name = "gcount",required = false)Integer gcount,HttpSession session) throws Exception {
        Object user = session.getAttribute("user");
        User user1 = (User)user;
        Good good = goodService.getGoodById(gid);
        UserDetail userDetail = userDetailService.getUserDetailById(udid);
        if(user1 != null&&good != null&&userDetail != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = sdf.format(new Date());

            Double money = good.getPrice() * gcount;
            Integer state = 0;
            Integer delivery = 0;
            Orders orders = new Orders(user1.getId(), gid, udid, time, money, state, gcount, delivery);

            Integer orid = ordersService.addOrders(orders);

            if (orid != null && orid != 0) {
                OrdersFand ordersFand = new OrdersFand(orid, user1, good, userDetail, time, money, state, gcount, delivery);
                session.setAttribute("ordersFand", ordersFand);
                return "confirmOrders";
            } else {
                return "redirect:main";
            }
        }else {
            return "redirect:main";
        }

    }


    @RequestMapping("ordersPayConfirm")
    protected String ordersPayConfirm (@RequestParam(name = "orid",required = false)Integer orid,HttpSession session) throws Exception {
        if(orid != null&&orid != 0) {
            Orders orders = ordersService.getOrdersById(orid);
            session.setAttribute("orders1",orders);
            return "ordersPay";
        }else {
            return "confirmOrders";
        }
    }

    @RequestMapping("payOrders")
    protected String payOrders(@RequestParam(name = "orid",required = false)Integer orid,@RequestParam(name = "money",required = false)Double money,HttpSession session) throws Exception {
        Orders orders = ordersService.getOrdersById(orid);
        User user = userService.getUserById(orders.getUid());
        if(user != null) {
            if (user.getMoney() - money >= 0) {
                user.setMoney(user.getMoney() - money);
                userService.updateUser(user);
                Stock stock = stockService.getStockByGid(orders.getGid());
                if (stock != null) {
                    stock.setGcount(stock.getGcount() - orders.getGcount());
                    stockService.updateStock(stock);
                    Integer state = 1;
                    orders.setState(state);
                    ordersService.updateOrders(orders);
                    session.setAttribute("strog", "0");

                } else {
                    session.setAttribute("strog", "1");
                }
            }
        }
        User user1 = (User)session.getAttribute("user");
        User user2 = userService.getUserById(user1.getId());
        session.setAttribute("mone",user2.getMoney());
        return "payResult";
    }


    @RequestMapping("toShowOrders")
    public String toShowOrders(HttpServletRequest request,HttpServletResponse response, HttpSession session)throws Exception{
        return showOrders(request,response,session);
    }


    @RequestMapping("showOrders")
    protected String showOrders(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        String status = "0";
        String status1 = request.getParameter("status");
        if(status1 != null){
            status = status1;
        }
        User user = (User) session.getAttribute("user");
        User user1 = userService.getUserById(user.getId());
        if(user1 != null) {
            Integer uid = user1.getId();
            List<Orders> list = ordersService.getOrdersByUid(uid);

            if (status.equals("1")) {//未付款订单
                list = ordersService.getOrdersByUidAndStateDelivery(uid, 0, 0);
            } else if (status.equals("2")) {//已付款订单
                list = ordersService.getOrdersByUidAndStateDelivery(uid, 1, 0);
            } else if (status.equals("3")) {//待退款订单
                list = ordersService.getOrdersByUidAndStateDelivery(uid, -1, 0);
            } else if (status.equals("4")) {//已退款订单
                list = ordersService.getOrdersByUidAndStateDelivery(uid, 2, 0);
            } else if (status.equals("5")) {//已发货订单
                list = ordersService.getOrdersByUidAndStateDelivery(uid, 1, 1);
            } else if (status.equals("6")) {//已收货订单
                list = ordersService.getOrdersByUidAndStateDelivery(uid, 1, 2);
            }

            String currentPage = request.getParameter("currentPage");
            int cp = 0;
            int pageSize = 8;
            if (currentPage != null) {
                cp = Integer.parseInt(currentPage);
            } else {
                cp = 1;
            }
            if (list != null&&list.size() != 0) {
                int totalRows = list.size();
                int totalPage = GetTotalPage.getTp(totalRows);
                List<List<Orders>> list1 = HibernateUtil.split(Orders.class, list, pageSize);
                List<Orders> orders1 = HibernateUtil.getSplit(Orders.class, list1, cp);
                List<OrdersFand> ordersFands = new ArrayList<>();

                for (int i = 0; i < orders1.size(); i++) {
                    Good good = goodService.getGoodById(orders1.get(i).getGid());
                    UserDetail userDetail = userDetailService.getUserDetailById(orders1.get(i).getUdid());
                    if (good != null && userDetail != null) {
                        ordersFands.add(new OrdersFand(orders1.get(i).getId(), user1, good, userDetail, orders1.get(i).getTime(), orders1.get(i).getMoney(), orders1.get(i).getState(), orders1.get(i).getGcount(), orders1.get(i).getDelivery()));

                    }
                }
                session.setAttribute("ofds", ordersFands);
                session.setAttribute("tp", totalPage);
            } else {
                List<OrdersFand> ordersFands = null;
                session.setAttribute("ofds", ordersFands);
                session.setAttribute("tp", 1);

            }
        }
        return "showOrders";
    }

    @RequestMapping("delOrders")
    protected String delOrders(@RequestParam(name = "orid",required = false)Integer orid) throws Exception {
        ordersService.delOrders(orid);
        return "redirect:showOrders";
    }


    @RequestMapping("moneyBackApplay")
    protected String moneyBackApplay(@RequestParam(name = "orid",required = false)Integer orid) throws Exception {
        if(orid != null) {
            Integer state = -1;
            Orders orders = ordersService.getOrdersById(orid);
            if(orders != null){
                orders.setState(state);
                ordersService.updateOrders(orders);
            }
        }
        return "redirect:showOrders";

    }


    @RequestMapping("confirmReceipt")
    protected String confirmReceipt(@RequestParam(name = "orid",required = false)Integer orid) throws Exception {
        if(orid != null) {
            Integer delivery = 2;
            Orders orders = ordersService.getOrdersById(orid);
            if(orders != null){
                orders.setDelivery(delivery);
                ordersService.updateOrders(orders);
            }
        }
        return "redirect:showOrders";

    }


}
