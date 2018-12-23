package cn.smile.springboot.service;

import cn.smile.springboot.model.MybatisPerson;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface MybatisPersonService {

    public List<MybatisPerson> selectPersons();

    public MybatisPerson getPersonById(int pid);

    public void updatePerson(MybatisPerson person);

    public void insert(MybatisPerson person);

    public void delete(int pid);

    public MybatisPerson getPersonByUserPass(Map<String,String> map);
}
