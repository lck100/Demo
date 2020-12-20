package com.demo.controller;

import com.demo.domain.Account;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/save")
    @ResponseBody
    public String save(Account account) {
        accountService.save(account);
        return "save success...";
    }

    @RequestMapping("findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {
        modelAndView.addObject("accountList", accountService.findAll());
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
