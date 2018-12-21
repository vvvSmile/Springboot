package cn.smile.springboot.srcconfig;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//创建数据源注册类
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource getDruidDataSource(){
        return new DruidDataSource();
    }

    //1、注册一个Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams=new HashMap<String, String>();
        initParams.put("loginUsername","root");
        initParams.put("loginPassword","root");
        initParams.put("allow",""); //默认就是允许访问所有资源
        initParams.put("deny","192.168.15.21"); //否认这个IP
        bean.setInitParameters(initParams);
        return bean;
    }

    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean=new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams=new HashMap<String, String>();
        initParams.put("exclusions","*.js,*.css,/druid/*"); //排除一些静态资源
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));  //过滤所有
        return bean;
    }

}
