package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @RequestMapping("/comment-list")
    public String commentList(){
        return "comment-list";
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

    @RequestMapping("/music")
    public String radioList1(ModelMap map){
        List<Music> musicList = musicService.getAllMusic();
        String size = String.valueOf(musicList.size());
        map.addAttribute("size",size);
        map.addAttribute("musicList",musicList);
        return "music";
    }

}
