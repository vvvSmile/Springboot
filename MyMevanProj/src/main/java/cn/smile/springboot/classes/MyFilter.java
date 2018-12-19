package cn.smile.springboot.classes;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 前置通知");
        chain.doFilter(request, response);
        System.out.println("doFilter 后置通知");

    }

    @Override
    public void destroy() {

    }
}
