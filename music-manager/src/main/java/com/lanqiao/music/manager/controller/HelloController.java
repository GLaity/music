package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @Reference
    private IMusicService musicService;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest req){

        SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = t.format(new Date());
        req.setAttribute("time",time);
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


    @RequestMapping("/comment-list")
    public String commentList(){
        return "comment-list";
    }

    @RequestMapping("/admin-add")
    public String adminList(){
        return "admin-add";
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
