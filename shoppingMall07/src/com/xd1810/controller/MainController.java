package com.xd1810.controller;

import com.xd1810.model.Good;
import com.xd1810.model.GoodFand;
import com.xd1810.model.Stock;
import com.xd1810.model.User;
import com.xd1810.service.GoodService;
import com.xd1810.service.StockService;
import com.xd1810.utils.GetTotalPage;
import com.xd1810.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Resource
    private GoodService goodService;
    @Resource
    private StockService stockService;

    @RequestMapping("search")
    @ResponseBody //将Java对象转换成json对象
    public Map<String,Object> search(String searchComment, HttpServletResponse response)throws Exception{
        if(searchComment == null||searchComment.isEmpty()){
            return null;
        }
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println(searchComment);
        List<Good> list = goodService.getGoodByLike(searchComment);
        Map<String,Object> map = new HashMap<>();
        System.out.println(list);
        map.put("goods",list);
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++");
        return map;
    }

    @RequestMapping("main")
    public String showGoods (@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if(currentPage != null){
            cp = currentPage;
        }else {
            cp = 1;
        }

        Integer state = 1;
        List<Good> goods = goodService.getGoodsByState(state);
        if(goods != null&&goods.size() != 0){
            int totalRows = goods.size();
            int totalPage = GetTotalPage.getTp(totalRows);
            List<List<Good>> list1 = HibernateUtil.split(Good.class, goods, pageSize);
            List<Good> goods1 = HibernateUtil.getSplit(Good.class, list1, cp);
            List<GoodFand> goodFands = new ArrayList<>();
            for (int i = 0; i < goods1.size(); i++) {
                Stock stock = stockService.getStockByGid(goods1.get(i).getId());
                if(stock != null){
                    goodFands.add(new GoodFand(goods1.get(i),stock));
                }else {
                    continue;
                }
            }
            session.setAttribute("goodFands",goodFands);
            session.setAttribute("tp",totalPage);

        }else {
            List<GoodFand> goodFands = null;
            session.setAttribute("goodFands",goodFands);
            session.setAttribute("tp",1);
        }
        session.setMaxInactiveInterval(60*60*24);
        return "main";
    }

    @RequestMapping("toSuccess")
    public String toSuccess()throws Exception{
        return "success";
    }

}
