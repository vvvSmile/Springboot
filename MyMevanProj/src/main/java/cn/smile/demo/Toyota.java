package cn.smile.demo;

import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car {
    @Override
    public void print(){
        System.out.println("I am Toyota");
    }
}
