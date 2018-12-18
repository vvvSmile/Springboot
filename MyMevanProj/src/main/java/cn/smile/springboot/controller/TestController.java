package cn.smile.springboot.controller;

import cn.smile.springboot.model.PersonJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }

    @ResponseBody
    @RequestMapping("/upload")  //diabled # path: /tx, otherwise unable to upload //视图解析器
    public String upload(@RequestParam("pic") MultipartFile file, HttpServletRequest request) {
        String contextType = file.getContentType();
        String fileName = file.getOriginalFilename();
        //System.out.println("fileName-->" + fileName);
        //System.out.println("getContentType-->" + contextType);
        //String filePath=request.getSession().getServletContext().getRealPath("imgupload"); //以前的web 项目的路径，
        // 现在不能这么做，Tomcat管理

        String filePath="D:/imgup/";
        try{
            this.uploadFile(file.getBytes(),filePath,fileName);
        }catch(Exception e){
            //TODO: handle exception
        }

        return "success";
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception{
        File targetFile=new File(filePath);
        if(!targetFile.exists())
        {
            targetFile.mkdirs();
        }
        FileOutputStream out=new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    @ResponseBody
    @RequestMapping("/hellojson")
    public PersonJson getJson(){
        PersonJson p=new PersonJson();
        p.setAge(18);
        p.setBirth(new Date());
        p.setName("HelloPersonJson");

        //返回一个json： {"name":"HelloPersonJson","age":18,"birth":"2018-12-18T13:56:19.991+0000"}
        //消息转换器的作用
        return p;
    }

}
