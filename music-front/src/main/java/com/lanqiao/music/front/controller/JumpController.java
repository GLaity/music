package com.lanqiao.music.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    @RequestMapping("/iframemain")
    public String iframemain(){
        return "main";
    }
    @RequestMapping("/iframemusic")
    public String iframemusic(){
        return "music";
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
    @RequestMapping("/playlistenty")
    public String playlistenter(){
        return "play-list-enter";
    }

}
