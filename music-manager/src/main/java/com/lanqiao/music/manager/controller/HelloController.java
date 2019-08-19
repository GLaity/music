package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class HelloController {

    @Reference
    private IMusicService musicService;

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/music-manage")
    public String musicManage(){
        return "music-manage";
    }

    @RequestMapping("/music-upload")
    public String musicUpload(){
        return "music-upload";
    }

    @RequestMapping("/admin-list")
    public String adminList(){
        return "admin-list";
    }

    @RequestMapping("/admin-vip-list")
    public String adminVipList(){
        return "admin-vip-list";
    }

    @RequestMapping("/buy-list")
    public String buyList(){
        return "buy-list";
    }

    @RequestMapping("/radio-list")
    public String radioList(){
        return "radio-list";
    }



}
