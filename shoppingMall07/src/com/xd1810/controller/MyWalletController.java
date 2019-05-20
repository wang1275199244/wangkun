package com.xd1810.controller;

import com.xd1810.model.User;
import com.xd1810.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class MyWalletController {
    @Resource
    private UserService userService;

    @RequestMapping("toMyWallet")
    public String toMyWallet(HttpSession session)throws Exception{
        return myWallet(session);
    }

    @RequestMapping("toRechargeConfirm")
    public String toRechargeConfirm(HttpSession session)throws Exception{
        return rechargeConfirm(session);
    }

    @RequestMapping("myWallet")
    protected String myWallet( HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        User user1 = userService.getUserById(user.getId());
        session.setAttribute("user1",user1);
        return "myWallet";
    }


    @RequestMapping("rechargeConfirm")
    protected String rechargeConfirm( HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        User user1 = userService.getUserById(user.getId());
        session.setAttribute("user1",user1);
        return "recharge";
    }

    @RequestMapping("recharge")
    protected String recharge(HttpServletRequest request, HttpSession session) throws Exception {
        Double money2 = Double.valueOf(request.getParameter("money1"));
        User user = (User) session.getAttribute("user");
        Double money3 = money2+user.getMoney();
        user.setMoney(money3);
        userService.updateUser(user);
        User user1 = userService.getUserById(user.getId());
        session.setAttribute("user1",user1);
        return "rechargeSuccess";
    }


    @RequestMapping("rechargeCheckPass")
    protected void rechargeCheckPass(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        String pass = request.getParameter("pass");
        if ("888888".equals(pass)){
            response.getWriter().write("0");
        }else{
            response.getWriter().write("1");
        }
    }

}
