package cn.smile.springboot;

import cn.smile.springboot.model.Person;
import cn.smile.springboot.model.Person2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAppTest {

    @Autowired
    Person person;

    @Autowired
    Person2 person2;


    @Test
    public void contextLoads(){
        System.out.println(person);
        System.out.println(person2);
    }
}
