package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserManager {
    @Reference
    private IUserService iUserService;
    @RequestMapping("list")
    public String  userList(Model model){

        List<User> users =iUserService.getAll();
        System.out.println(users);
        model.addAttribute("users",users);
        return  "hello";
    }

}
