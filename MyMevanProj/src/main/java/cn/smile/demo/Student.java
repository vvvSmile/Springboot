package cn.smile.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
public class Student {
    //@Bean("student")
    public void print(){
        System.out.println("I am Student Smile");
    }
}
