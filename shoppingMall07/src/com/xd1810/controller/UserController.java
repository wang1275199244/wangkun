package com.xd1810.controller;

import com.xd1810.model.BuyCar;
import com.xd1810.model.User;
import com.xd1810.service.BuyCarService;
import com.xd1810.service.UserService;
import com.xd1810.utils.GetCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private BuyCarService buyCarService;

    @RequestMapping("checkLogin")
    protected String checkLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws Exception {
        Cookie[] cookies = request.getCookies();
        Cookie cookie1 = GetCookie.getCookie(cookies, "name");
        Cookie cookie2 = GetCookie.getCookie(cookies, "pass");
        if(cookie1 != null&&cookie2 != null){
            User user = userService.getUserByNameAndPass(cookie1.getValue(), cookie2.getValue());
            if(user != null){
                session.setAttribute("user",user);
                return "success";
            }else{
                return "login";
            }
        }else {//没有登录过
            Cookie cookieName = new Cookie("name","");
            Cookie cookiePass = new Cookie("pass","");
            cookieName.setMaxAge(0);
            cookiePass.setMaxAge(0);
            response.addCookie(cookieName);
            response.addCookie(cookiePass);
            return "login";
        }
    }

    @RequestMapping("toLogin")
    public String toLogin()throws Exception{
        return "login";
    }

    @RequestMapping("toRegister")
    public String toRegister()throws Exception{
        return "register";
    }

    @RequestMapping("toLogOut")
    public String toLogOut(HttpSession session, HttpServletResponse response)throws Exception{
        return logOut(session,response);
    }

    @RequestMapping("login")
    protected String login(String name,String pass,String log, HttpServletResponse response, HttpSession session)throws Exception {
        User user = userService.login(name, pass);
        if (user!=null) {
            if (user.getName().equals(name) && user.getPass().equals(pass)) {
                if ("on".equals(log)) {
                    Cookie cookieName = new Cookie("name",name);
                    Cookie cookiePass = new Cookie("pass",pass);
                    cookieName.setMaxAge(60 * 60);
                    cookiePass.setMaxAge(60 * 60);
                    response.addCookie(cookieName);
                    response.addCookie(cookiePass);

                }
                session.setAttribute("user", user);
                return "success";
            }else {
                return "login";
            }
        }else {

            return "login";
        }
    }

    @RequestMapping("checkName")
    protected void checkName(String name,HttpServletResponse response) throws Exception {
        User user = userService.getUserByName(name);
        if(user != null){
            response.getWriter().write("0");
        }else{
            response.getWriter().write("1");
        }
    }

    @RequestMapping("register")
    protected String register(String name,String pass,String sex) throws Exception {
        Double money = 0.0;
        User user = new User(name, pass, sex , money);
        boolean isOK = userService.register(user);
        if(isOK){//注册成功
            User user1 = userService.getUserByNameAndPass(name, pass);
            if(user1 != null) {
                BuyCar buyCar = new BuyCar(user1.getId());
                buyCarService.addBuyCar(buyCar);
            }
            return "login";
        }else{
            return "register";
        }
    }

    @RequestMapping("logOut")
    protected String logOut(HttpSession session, HttpServletResponse response) throws Exception {
        session.invalidate();
        Cookie cookieName = new Cookie("name","");
        Cookie cookiePass = new Cookie("pass","");
        cookieName.setMaxAge(0);
        cookiePass.setMaxAge(0);
        response.addCookie(cookieName);
        response.addCookie(cookiePass);
        return "forward:main";
    }
}
