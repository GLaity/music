package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Reference
    private IUserService iUserService;

    @RequestMapping("/")
    public String init(){
        return "musicplay";
    }

    @RequestMapping("/login")
    public String loginCheck(String uname, String upwd){
        int flag = 5;
        flag = iUserService.login(uname,upwd);
        if (flag == 0){
            return "index";
        } else {
            return "login";
        }
    }
}
