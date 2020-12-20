package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class IndexController {
    @RequestMapping("test")
    public ModelAndView test(ModelAndView modelAndView){
        System.out.println("目标资源执行......");
        modelAndView.addObject("username","张三");
        modelAndView.setViewName("index.jsp");
        return modelAndView;
    }
}
