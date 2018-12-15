package cn.smile.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class HelloController {

    @ResponseBody
    @RequestMapping("/smile")
    public String index(){
        return "hello world, Smile rrr";
    }
}
