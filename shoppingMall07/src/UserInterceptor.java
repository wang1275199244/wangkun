
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setHeader("Content-Type","text/html;charset=UTF-8");
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if(user == null){
            httpServletResponse.getWriter().write("返回>>"+"<a href=\"main\" >首页</a></br>");
            httpServletResponse.getWriter().write("请先>>"+"<a href=\"toLogin\" >登录</a>");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle======");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion======");
    }
}

