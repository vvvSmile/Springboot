package cn.smile.springboot.controller;

import cn.smile.springboot.model.MybatisPerson;
import cn.smile.springboot.service.MybatisPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MybatisPersonControllder {

    @Autowired
    MybatisPersonService personService;

    //查询
    @GetMapping("/main")
    public String main(Model model){  //添加Model将数据返回给页面,然后在main页面展示，这里main页面以table方式展示
        List<MybatisPerson> pList= personService.selectPersons();
        model.addAttribute("pList",pList);
        return "main";  //返回main页面
    }

    @PostMapping("/save")  //error (type=Method Not Allowed, status=405).得用@PostMapping
    public String save(MybatisPerson person){
        personService.insert(person);
        return "redirect:main";  //添加完user之后跳转到main页面
    }

}
