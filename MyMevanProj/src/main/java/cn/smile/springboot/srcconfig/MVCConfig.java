package cn.smile.springboot.srcconfig;

import cn.smile.springboot.interceptor.LoginInterceptor;
import cn.smile.springboot.TestInterceptor;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //http://localhost:8081/formtest
        //单独页面的跳转，不再需要写空方法了
        registry.addViewController("/formtest").setViewName("form");

        // add by 37 springboot开发企业信息系统查询
        // http://localhost:8081/index
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/header").setViewName("header");
        registry.addViewController("/add").setViewName("add");
        registry.addViewController("/main").setViewName("main");  //应该创建MybatisPersonController替代
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/toLogin").setViewName("login");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //注册转化器，
        //日期格式化
        //没有太大必要因为可以通过配置直接实现这个功能 #spring.mvc.date-format=yyyy-MM-dd
        registry.addFormatter(new Formatter<Date>() {
            @Override
            public Date parse(String text, Locale locale) throws ParseException {
                return new SimpleDateFormat("yyyy-MM-dd").parse(text);
            }

            @Override
            public String print(Date object, Locale locale) {
                return null;
            }
        });
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //扩展-配置消息转化器 Alibaba- FastJson
        FastJsonHttpMessageConverter fc = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fc.setFastJsonConfig(fastJsonConfig);
        converters.add(fc);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器--链式结构
        registry.addInterceptor(new TestInterceptor())
                .addPathPatterns("/**") //表示拦截所有
                .excludePathPatterns("/helloAliJson")  //不拦截/helloAliJson
                .excludePathPatterns("/**"); //不拦截

        /* 测试有效，现在注释掉，否则没登录的时候其他的页面都不能访问。
        //登录拦截器
        List<String> excludePatterns=new ArrayList<String>();  //列出哪些不需要被拦截，一般登录页面和静态资源不需要拦截
        excludePatterns.add("/css/**");
        excludePatterns.add("/images/**");
        excludePatterns.add("/toLogin");
        excludePatterns.add("/login");

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //表示拦截所有
                .excludePathPatterns(excludePatterns);
        */
    }
}
