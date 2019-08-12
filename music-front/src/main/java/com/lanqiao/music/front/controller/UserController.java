package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class UserController {

    @Reference
    private IUserService iUserService;

//    @RequestMapping("/")
//    public String init(){
//        return "musicplay";
//    }

    @RequestMapping("/login")
    public String loginCheck(String uname, String upwd, Model model){
        User user = iUserService.login(uname,upwd);
        if (user != null){
            model.addAttribute("user",user);
            return "index";
        } else {
            return "login";
        }
    }
}
