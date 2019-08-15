package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IMusicService;
import com.lanqiao.music.server.service.ISheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MusicController {
    @Reference
    private IMusicService iMusicService;

    @Reference
    private ISheetService iSheetService;
    @RequestMapping("/music")
    public String findAllMusic(Model model){
        List<Music> musicList = iMusicService.queryAllMusic();
        model.addAttribute("musicList",musicList);
        return "musicplay";
    }

//    @RequestMapping("/userSheet")
//    public String findAllSheetByUser(@ModelAttribute("user") User user,Model model){
//        List<Sheet> userSheet = iSheetService.search(user);
//        model.addAttribute("userSheet",userSheet);
//        return "index";
//    }
}
