package cn.smile.demo;

/***
 * @Configuration: 指明当前类是一个配置类；就是用来替代之前的Spring配置文件
 * 在配置文件中用<bean></bean>标签添加组件
 */

import cn.smile.springboot.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTest {

    //将方法的返回值添加到容器中；容器中这个组件中默认的组件id就是方法名
    @Bean
    public BeanTest BeanTest(){
        System.out.println("BeanTest in BeanTest()");
        return new BeanTest();
    }
}
