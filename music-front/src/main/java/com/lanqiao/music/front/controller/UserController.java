package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Reference
    private IUserService iUserService;

    @RequestMapping("/")
    public String init(){
        return "login";
    }

    @RequestMapping("/play")
    public String playMusic(Model model){
        List<String> songList = new ArrayList<>();
        for (int i = 1; i <=5; i++){
            songList.add("" + i);
            System.out.println(songList);
        }
        model.addAttribute("songList",songList);
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
