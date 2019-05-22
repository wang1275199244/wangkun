package com.wk.controller;

import com.wk.model.Visitor;
import com.wk.service.VisitorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class VisitorController {
    @Resource
    private VisitorService visitorService;



    @RequestMapping("toVisitorLogin")
    public String toVisitorLogin()throws Exception{
        return "visitorLogin";
    }

    @RequestMapping("toRegister")
    public String toRegister()throws Exception{
        return "register";
    }

    @RequestMapping("toLogOut")
    public String toLogOut(HttpSession session)throws Exception{
        session.invalidate();
        return "forward:toFirst";
    }

    @RequestMapping("visitorLogin")
    protected String visitorLogin(String name, String pass,HttpServletResponse response, HttpSession session)throws Exception {
        Visitor visitor = new Visitor(name, pass);
        Visitor visitor1 = visitorService.VisitorLogin(visitor);
        if (visitor1 != null) {
            session.setAttribute("visitor", visitor1);
            return "../../index";
        } else {
            return "visitorLogin";
        }
    }

    @RequestMapping("checkName")
    protected void checkName(String name,HttpServletResponse response) throws Exception {
        Visitor visitor = visitorService.getVisitorByName(name);
        if(visitor != null){
            response.getWriter().write("0");
        }else{
            response.getWriter().write("1");
        }
    }

    @RequestMapping("register")
    protected String register(String name,String pass) throws Exception {
        Visitor visitor = new Visitor(name, pass);
        boolean isOK = visitorService.register(visitor);
        if(isOK){//注册成功
            return "visitorLogin";
        }else{
            return "register";
        }
    }


}
