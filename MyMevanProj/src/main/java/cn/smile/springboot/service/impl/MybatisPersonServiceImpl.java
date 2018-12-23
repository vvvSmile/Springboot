package cn.smile.springboot.service.impl;

import cn.smile.springboot.mapper.MybatisPersonMapper;
import cn.smile.springboot.model.MybatisPerson;
import cn.smile.springboot.service.MybatisPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MybatisPersonServiceImpl implements MybatisPersonService {

    @Autowired //注入MybatisPersonMapper
    private MybatisPersonMapper personMapper;

    @Override
    public List<MybatisPerson> selectPersons() {
        return personMapper.selectPersons();
    }

    @Override
    public MybatisPerson getPersonById(int pid) {
        return personMapper.getPersonById(pid);
    }

    @Override
    public void updatePerson(MybatisPerson person) {
        personMapper.updatePerson(person);
    }

    @Override
    public void insert(MybatisPerson person) {
        personMapper.insert(person);
    }

    @Override
    public void delete(int pid) {
        personMapper.delete(pid);
    }

    @Override
    public MybatisPerson getPersonByUserPass(Map<String, String> map) {
        return personMapper.getPersonByUserPass(map);
    }

}
