package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("check")
    public String check(String username){
        System.out.println(username);
        return "success";
    }
}
