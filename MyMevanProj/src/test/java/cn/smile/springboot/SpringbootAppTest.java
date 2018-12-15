package cn.smile.springboot;

import cn.smile.springboot.model.Person;
import cn.smile.springboot.model.Person2;
import cn.smile.springboot.model.Person3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAppTest {

    @Autowired
    Person person;

    @Autowired
    Person2 person2;

    @Autowired
    Person3 person3;

    @Autowired
    ApplicationContext context;


    @Test
    public void contextLoads(){
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);

        Object person4=context.getBean("person4");
        System.out.println(person4);
    }
}
