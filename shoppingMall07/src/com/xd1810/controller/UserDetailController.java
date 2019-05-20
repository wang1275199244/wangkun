package com.xd1810.controller;

import com.xd1810.model.Orders;
import com.xd1810.model.User;
import com.xd1810.model.UserDetail;
import com.xd1810.service.OrdersService;
import com.xd1810.service.UserDetailService;
import com.xd1810.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class UserDetailController {

    @Resource
    private UserService userService;
    @Resource
    private UserDetailService userDetailService;
    @Resource
    private OrdersService ordersService;

    @RequestMapping("toShowUserDetail")
    public String toShowUserDetail(HttpServletResponse response, HttpSession session)throws Exception{
        return showUserDetail(response,session);
    }

    @RequestMapping("showUserDetail")
    protected String showUserDetail(HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        User user = (User)session.getAttribute("user");
        User user1 = userService.getUserById(user.getId());
        List<UserDetail> userDetails = userDetailService.getUserDetailByUid(user1.getId());
        session.setAttribute("uds1",userDetails);
        return "showUserDetail";
    }

    @RequestMapping("addUserDetail")
    protected String addUserDetail(String receiver1,String phone1,String address1,HttpSession session) throws Exception {
        User user = (User)session.getAttribute("user");
        UserDetail userDetail = new UserDetail(receiver1,phone1,address1,user.getId());
        userDetailService.addUserDetail(userDetail);

        return "redirect:showUserDetail";
    }

    @RequestMapping("updateUserDetail")
    protected String updateUserDetail(@RequestParam(name = "id2",required = false)Integer id2, String receiver2, String phone2, String address2,HttpSession session) throws Exception {
        User user = (User)session.getAttribute("user");
        UserDetail userDetail = new UserDetail(id2,receiver2,phone2,address2,user.getId());
        userDetailService.updateUserDetail(userDetail);

        return "redirect:showUserDetail";
    }

    @RequestMapping("delUserDetail")
    protected String delUserDetail(@RequestParam(name = "id2",required = false)Integer id2) throws Exception {
        if (id2 != null) {
            List<Orders> orders = ordersService.getOrdersByUdid(id2);
            if(orders != null&&orders.isEmpty()){
                userDetailService.delUserDetail(id2);
            }

        }
        return "redirect:showUserDetail";
    }
}
