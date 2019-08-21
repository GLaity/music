package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

    @RequestMapping("/hello")
    public String hello(Model model){
        int[] a = new int[5];
        List<Music> musicList = musicService.getAllMusic();
        int b = musicList.size();
        Iterator iterator=musicList.iterator();
        while(iterator.hasNext()){
            Music music = (Music) iterator.next();
            if(music.getMlanguage().equals("国语")){
                a[0]++;
            }
            if(music.getMlanguage().equals("日语")){
                a[1]++;
            }
            if(music.getMlanguage().equals("英语")){
                a[2]++;
            }
            if(music.getMlanguage().equals("韩语")){
                a[3]++;
            }
        }
        a[4]=b-a[1]-a[2]-a[0]-a[3];
        a[0]=a[0]*100/b;
        a[1]=a[1]*100/b;
        a[2]=a[2]*100/b;
        a[3]=a[3]*100/b;
        a[4]=100-a[1]-a[2]-a[0]-a[3];
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);
        model.addAttribute("sa",a);
        return "hello";
    }

}
