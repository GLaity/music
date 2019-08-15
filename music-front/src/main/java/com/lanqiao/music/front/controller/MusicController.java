package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MusicController {
    @Reference
    private IMusicService iMusicService;

    @RequestMapping("/music")
    public String findAllMusic(Model model){
        List<Music> musicList = iMusicService.queryAllMusic();
        model.addAttribute("musicList",musicList);
        return "musicplay";
    }
}
