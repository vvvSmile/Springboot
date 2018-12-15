package cn.smile.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextLoaderTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ParentConfig.class,Student.class,BeanTest.class);
        Car car=(Car) context.getBean("toyota");
        car.print();

        Car bmw=(Car) context.getBean("bmw");
        bmw.print();

        Student student=(Student) context.getBean("student");
        student.print();

        BeanTest beanTest=(BeanTest)context.getBean("BeanTest");
        System.out.println(beanTest);

    }
}
