package cn.smile.springboot.model;

import java.util.Date;

//根据数据库中的表结构创建实体类
public class MybatisPerson {

    private  int pid;
    private String username;
    private String password;
    private String addr;
    private String gender;
    private Date birth;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "MybatisPerson{" +
                "pid=" + pid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + addr + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                '}';
    }
}
