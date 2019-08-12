package com.lanqiao.music.manager.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {
    @RequestMapping("/")
    public String init(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest req){
        if(username == null || username.equals("") ){
            req.setAttribute("prompt","用户名或密码错误,请重新登录");
            return "login";
        }
        if(username.equals("admin") && password.equals("123456") ){
            return "redirect:/user/list";
        }
        req.setAttribute("prompt","用户名或密码错误");
        return "login";

    }

}
