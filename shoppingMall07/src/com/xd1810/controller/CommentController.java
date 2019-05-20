package com.xd1810.controller;

import com.xd1810.model.*;
import com.xd1810.service.CommentService;
import com.xd1810.service.GoodService;
import com.xd1810.service.OrdersService;
import com.xd1810.service.UserService;
import com.xd1810.utils.GetTotalPage;
import com.xd1810.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class CommentController {
    @Resource
    private OrdersService ordersService;
    @Resource
    private CommentService commentService;
    @Resource
    private GoodService goodService;
    @Resource
    private UserService userService;

    @RequestMapping("addComment")
    protected String addComment(@RequestParam(name = "orid",required = false)Integer orid,HttpSession session) throws Exception {
        if(orid != null) {
            Orders orders = ordersService.getOrdersById(orid);
            if(orders != null){
                session.setAttribute("orders2",orders);
                return "comment";
            }
        }
        return "redirect:showOrders";
    }


    @RequestMapping("comment")
    protected String comment(@RequestParam(name = "orid",required = false)Integer orid,@RequestParam(name = "comment",required = false)String comment,HttpSession session) throws Exception {
        if(orid != null&&comment != null&&comment != ""){
            Orders orders = ordersService.getOrdersById(orid);
            Comment comment1 = new Comment(orders.getGid(),comment,orders.getUid());
            commentService.addComment(comment1);
        }
        return "redirect:main";
    }


    @RequestMapping("getComments")
    protected String getComments(@RequestParam(name = "id",required = false)Integer id,@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        int cp = 0;
        int pageSize = 8;
        if(currentPage != null){
            cp = currentPage;
        }else {
            cp = 1;
        }

        Good good = goodService.getGoodById(id);
        List<Comment> comments = commentService.getCommentsByGid(id);
        if(comments != null&&comments.size() != 0){
            int totalRows = comments.size();
            int totalPage = GetTotalPage.getTp(totalRows);
            List<Comment> list = new ArrayList<>(comments);
            List<List<Comment>> list1 = HibernateUtil.split(Comment.class, list, pageSize);
            List<Comment> comments1 = HibernateUtil.getSplit(Comment.class, list1, cp);
            List<CommentsFand> commentsFands = new ArrayList<>();
            for (int i = 0; i < comments1.size(); i++) {
                User user = userService.getUserById(comments1.get(i).getUid());
                if (user != null) {
                    commentsFands.add(new CommentsFand(comments1.get(i).getId(), good, comments1.get(i).getComment(), user));

                }
                session.setAttribute("good", good);
                session.setAttribute("cfs", commentsFands);
                session.setAttribute("tp", totalPage);
            }
        }else {
            List<CommentsFand> commentsFands = null;
            session.setAttribute("good",good);
            session.setAttribute("cfs",commentsFands);
            session.setAttribute("tp",1);
        }
        return "showComments";
    }

}
