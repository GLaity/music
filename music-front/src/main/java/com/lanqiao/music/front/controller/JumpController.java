package com.lanqiao.music.front.controller;

import com.lanqiao.music.server.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class JumpController {
    @RequestMapping("/iframemain")
    public String iframemain(){
        return "main";
    }
    @RequestMapping("/iframemusic")
    public String iframemusic(){
        return "songs";
    }
    @RequestMapping("/iframecollection")
    public String iframecollection(){
        return "collection";
    }
    @RequestMapping("/iframegenres")
    public String iframegenres(){
        return "genres";
    }
    @RequestMapping("/iframeplay-list")
    public String iframeplaylist(){
        return "play-list";
    }
    @RequestMapping("/iframemyplaylist")
    public String iframemyplaylist(){
        return "myplaylist";
    }
    @RequestMapping("/iframesearch")
    public String iframesearch(){
        return "search";
    }
    @RequestMapping("/iframevideo")
    public String iframevideo(){
        return "video";
    }
    @RequestMapping("/iframepersonal")
    public String iframepersonal(){
        return "personal";
    }

}