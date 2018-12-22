package cn.smile.springboot;

/***
 *
 */

import cn.smile.springboot.classes.MyFilter;
import cn.smile.springboot.classes.MyListener;
import cn.smile.springboot.classes.MyServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;
//import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;

@MapperScan("cn.smile.springboot.mapper")
@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringbootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApp.class, args);
    }



    /****真实情况下一下信息应该被抽到另外的class*****/
    /****真实情况下一下信息应该被抽到另外的class*****/
    /****真实情况下一下信息应该被抽到另外的class*****/
    //注册MyServlet
    @Bean
    public ServletRegistrationBean getMyServlet() {
        ServletRegistrationBean<MyServlet> myServlet = new ServletRegistrationBean<MyServlet>(new MyServlet(), "/myservlet");
        return myServlet;
    }

    //注入Filter
    @Bean
    public FilterRegistrationBean getMyFilter(){
        FilterRegistrationBean<MyFilter> myFilter=new FilterRegistrationBean<MyFilter>(new MyFilter());
        myFilter.setFilter(new MyFilter());
        myFilter.setUrlPatterns(Arrays.asList("/myservlet")); //拦截/myservlet
        return  myFilter;
    }

    //注册MyListener
    @Bean
    public ServletListenerRegistrationBean getMyListener() {
        ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());
        return myListenerServletListenerRegistrationBean;
    }


}
