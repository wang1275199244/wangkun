package com.xd1810.controller;

import com.xd1810.model.*;
import com.xd1810.service.BuyCarService;
import com.xd1810.service.BuyDetailService;
import com.xd1810.service.GoodService;
import com.xd1810.service.UserService;
import com.xd1810.utils.GetTotalPage;
import com.xd1810.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class BuyDetailController {
    @Resource
    private UserService userService;
    @Resource
    private GoodService goodService;
    @Resource
    private BuyDetailService buyDetailService;
    @Resource
    private BuyCarService buyCarService;

    @RequestMapping("toShowBuyCar")
    public String toShowBuyCar(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletResponse response,HttpSession session)throws Exception{
        return showBuyCar(currentPage,response,session);
    }

        @RequestMapping("showBuyCar")
        protected String showBuyCar(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletResponse response,HttpSession session) throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if(currentPage != null){
            cp = currentPage;
        }else {
            cp = 1;
        }

        User user = (User) session.getAttribute("user");
        User user1 = userService.getUserById(user.getId());
            BuyCar buyCar = buyCarService.getBuyCarByUid(user1.getId());
            if(buyCar != null) {
                List<BuyDetail> buyDetails = buyDetailService.getBuyDetailByBcid(buyCar.getId());
                if (buyDetails != null&&buyDetails.size() != 0) {
                    int totalRows = buyDetails.size();
                    int totalPage = GetTotalPage.getTp(totalRows);
                    List<BuyDetail> list = new ArrayList<>(buyDetails);
                    List<List<BuyDetail>> list1 = HibernateUtil.split(BuyDetail.class, list, pageSize);
                    List<BuyDetail> buyDetails1 = HibernateUtil.getSplit(BuyDetail.class, list1, cp);
                    List<BuyDetailFand> buyDetailFands = new ArrayList<>();
                    for (int i = 0; i < buyDetails1.size(); i++) {
                        Good good = goodService.getGoodById(buyDetails1.get(i).getGid());
                        if(good != null){
                            buyDetailFands.add(new BuyDetailFand(buyDetails1.get(i).getId(),good,buyDetails1.get(i).getGcount(),buyCar));
                        }else {
                            continue;
                        }
                    }
                    session.setAttribute("bdfs", buyDetailFands);
                    session.setAttribute("tp", totalPage);

                } else {
                    List<BuyDetailFand> buyDetailFands = null;
                    session.setAttribute("bdfs", buyDetailFands);
                    session.setAttribute("tp", 1);
                }
            }
        return "showBuyCar";
    }

    @RequestMapping("addBuyDetail")
    protected String addBuyDetail(@RequestParam(name = "id",required = false)Integer id,@RequestParam(name = "gcount",required = false)Integer gcount,HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        if(user == null){//没有登陆
            return "login";
        }else {//已经登录
            BuyCar buyCar = buyCarService.getBuyCarByUid(user.getId());
            if(buyCar != null) {
                BuyDetail buyDetail = new BuyDetail(id, buyCar.getId());
                BuyDetail buyDetail3 = buyDetailService.getBuyDetail(buyDetail);
                if (buyDetail3 == null) {//购物车中没有此商品，则将此商品直接加入购物车
                    BuyDetail buyDetail1 = new BuyDetail(id, gcount, buyCar.getId());
                    buyDetailService.addBuyDetail(buyDetail1);
                } else {
                    Integer gcount2 = buyDetail3.getGcount() + gcount;
                    buyDetail3.setGcount(gcount2);
                    buyDetailService.updateBuyDetail(buyDetail3);
                }
            }
            return "redirect:showBuyCar";
        }
    }

    @RequestMapping("updateBuyDetail")
    protected String updateBuyDetail(@RequestParam(name = "id",required = false)Integer id,@RequestParam(name = "gid",required = false)Integer gid,@RequestParam(name = "gcount",required = false)Integer gcount,HttpSession session) throws Exception {
        Good good = goodService.getGoodById(gid);
        User user = (User) session.getAttribute("user");
        BuyCar buyCar = buyCarService.getBuyCarByUid(user.getId());
        if(buyCar != null) {
            if (id != null && good != null && gcount != null && buyCar != null) {
                BuyDetail buyDetail = new BuyDetail(id, gid, gcount, buyCar.getId());
                buyDetailService.updateBuyDetail(buyDetail);
            }
        }
        return "redirect:showBuyCar";
    }

    @RequestMapping("delBuyDetail")
    protected String delBuyDetail(@RequestParam(name = "id",required = false)Integer id) throws Exception {
        if (id != null) {
            buyDetailService.delBuyDetail(id);
        }
        return "redirect:showBuyCar";
    }
}
