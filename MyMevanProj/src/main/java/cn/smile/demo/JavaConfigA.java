package cn.smile.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigA {
    @Bean("toyota")
    public Car getToyota(){
        return new Toyota();
    }
}
