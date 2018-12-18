package cn.smile.springboot.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class PersonJson {

    private String name;

    private int age;

    @JSONField(format = "yyyy--MM--dd")
    //Alibaba jason  http://localhost:8081/helloAliJson
    //disabled:{ "age":18, "birth":1545144630623, "name":"HelloAliJson" }
    //enabled: { "age":18, "birth":"2018--12--18", "name":"HelloAliJson" }
    private Date birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
