package cn.smile.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TemplateController {

    //@ResponseBody  //因为有页面跳转就不需要这个注解了
    @RequestMapping("/toLogin")
    public String toLogin(){
        //两个return都能成功访问到模板页，注意不需要添加前缀后缀，因为Thymeleaf自动配置类有默认的前缀和后缀等属性
        return "login";
        //return "indexTemplate";
    }
}
