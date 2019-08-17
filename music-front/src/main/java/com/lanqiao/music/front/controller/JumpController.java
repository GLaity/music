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
}
