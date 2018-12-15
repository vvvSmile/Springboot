package cn.smile.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController
public class HelloController2 {

    @ResponseBody
    @RequestMapping("/smile2")
    public String index(){
        return "hello world, Smile 222";
    }
}
