package cn.smile.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigB {
    @Bean("bmw")
    public Car getToyota(){
        return new BMW();
    }
}
