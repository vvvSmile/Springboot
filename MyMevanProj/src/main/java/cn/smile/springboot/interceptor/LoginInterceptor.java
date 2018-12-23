package cn.smile.springboot.interceptor;

import cn.smile.springboot.model.MybatisPerson;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MybatisPerson user = (MybatisPerson)request.getSession().getAttribute("user");
        if(user != null){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/toLogin");  //登录拦截，如果用户没登录则跳转到login页面
        return false;
    }
}
