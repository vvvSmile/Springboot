package cn.smile.springboot;

import cn.smile.springboot.model.ThymeleafPerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class TemplateController {

    //@ResponseBody  //因为有页面跳转就不需要这个注解了
    @RequestMapping("/toLogin")
    public String toLogin() {
        //两个return都能成功访问到模板页，注意不需要添加前缀后缀，因为Thymeleaf自动配置类有默认的前缀和后缀等属性
        return "login";
        //return "indexTemplate";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("hello", "tx test");

        ThymeleafPerson person = new ThymeleafPerson();
        person.setUsername("User Name Handsome");
        person.setPassword("123456");
        person.setBirth(new Date());

        model.addAttribute("personAtt", person); //用来把对象传给前端

        List<ThymeleafPerson> list = new ArrayList<ThymeleafPerson>();
        for (int i = 0; i < 10; i++) {
            ThymeleafPerson p1 = new ThymeleafPerson();
            p1.setUsername("User Name Handsome" + i);
            p1.setPassword("123456" + i);
            p1.setBirth(new Date());
            list.add(p1);
        }
        model.addAttribute("list", list);

        return "test";
    }

    @RequestMapping("/test1")
    public String test1(Model model, HttpSession session) {

        ThymeleafPerson person = new ThymeleafPerson();
        person.setUsername("User Name Handsome");
        person.setPassword("123456");
        person.setBirth(new Date());
        session.setAttribute("user",person);//用来把对象传给前端
        model.addAttribute("user",person);

        return "test1";
    }
}
