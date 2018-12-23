package cn.smile.springboot.mapper;

import cn.smile.springboot.model.MybatisPerson;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

//注解方式整合mybatis
//@Mapper  //--> 前一节34中说的@Mapper注解，也可以不再mapper类中加@Mapper，而是在SpringbootApp中添加一个注解： @MapperScan("cn.smile.springboot.mapper")
public interface MybatisPersonMapper {

    @Select("select * from mybatis_person")  //数据库中的表
    public List<MybatisPerson> selectPersons();

    @Select("select * from mybatis_person where pid = #{pid}")  //数据库中的表
    public MybatisPerson getPersonById(int pid);

    @Options(useGeneratedKeys = true, keyProperty = "pid")  //数据库自增列处理
    @Insert("insert into mybatis_person(pid, username, password, addr, gender, birth) " +
            "values(#{pid},#{usernmae},#{password},#{addr},#{gender},#{birth})")  //数据库中的表
    public void insert(MybatisPerson person);

    @Update("update mybatis_person set username = #{username} , password = #{password}, addr = #{addr}, gender = #{gender}, birth = #{birth} " +
            "where pid = #{pid}")  //数据库中的表
    public void updatePerson(MybatisPerson person);

    @Delete("delete from mybatis_person where pid=#{pid}")
    public void delete(int pid);

    //配置文件方式mybatis
    public List<MybatisPerson> getPersons();

    @Select("select from mybatis_person where username= #{username}and  pid=#{pid}")
    public MybatisPerson getPersonByUserPass(Map<String,String> map);


}
