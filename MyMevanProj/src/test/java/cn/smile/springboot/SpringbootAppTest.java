package cn.smile.springboot;

import cn.smile.springboot.mapper.MybatisPersonMapper;
import cn.smile.springboot.model.MybatisPerson;
import cn.smile.springboot.model.Person;
import cn.smile.springboot.model.Person2;
import cn.smile.springboot.model.Person3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

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

    //数据源测试
    @Autowired
    DataSource dataSource;


    //注入JdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;


    //测试注解方式mybatis
    @Autowired
    MybatisPersonMapper personMapper;

    @Test
    public void contextLoads(){
        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);

        Object person4=context.getBean("person4");
        System.out.println(person4);

        //System.out.println(dataSource);  //控制台打印出来了数据源 HikariDataSource (null)

        System.out.println(dataSource);  //测试DruidDataSource

        //jdbcTemplate应用
        //org.springframework.jdbc.CannotGetJdbcConnectionException: Failed to obtain JDBC Connection; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Unknown database 'boot_demo'
        /*
        List<Map<String,Object>> maps=jdbcTemplate.queryForList("SELECT 1 FROM DUAL");
        System.out.println(maps);  //测试jdbcTemplate
        */
    }


    //测试mybatis --测试之前得确保数据库没问题
    @Test
    public void testMybatis(){
        List<MybatisPerson> mybatisPerson=personMapper.selectPersons();
        System.out.println(mybatisPerson);

    }
    @Test
    public void saveMybatisPerson(){
        MybatisPerson mybatisPerson=new MybatisPerson();
        mybatisPerson.setAddr("shanghai");
        mybatisPerson.setBirth(new Date());
        mybatisPerson.setGender("1");
        mybatisPerson.setPassword("123");
        mybatisPerson.setUsername("handsome");
        //mybatisPerson.setPid(1);
        personMapper.insert(mybatisPerson);
    }
    @Test
    public void deleteMybatisPerson(){
        personMapper.delete(1);
    }


}
