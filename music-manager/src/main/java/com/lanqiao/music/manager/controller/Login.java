package com.lanqiao.music.manager.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class Login {
    @RequestMapping("/")
    public String init(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest req){
        SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = t.format(new Date());
        if(username == null || username.equals("") ){
            req.setAttribute("prompt","用户名或密码错误,请重新登录");
            return "login";
        }
        if(username.equals("admin") && password.equals("123456") ){
//            return "redirect:/user/list";
            req.setAttribute("username",username);
            req.setAttribute("time",time);
            return "index";
        }

        req.setAttribute("prompt","用户名或密码错误");

        return "login";

    }




}
