package cn.smile.demo;

import org.springframework.stereotype.Component;

@Component
public class BMW implements Car {
    @Override
    public void print(){
        System.out.println("I am BMW");
    }
}
