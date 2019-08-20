package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class JumpController {
    @Reference
    private ISheetService iSheetService;
    @Reference
    private IMusicService iMusicService;

    @RequestMapping("/iframemain")
    public String iframemain(Model model){
        List<Music> music = iMusicService.queryAllMusic();
        List<Music> musicList1=new ArrayList<>();
        List<Music> musicList2 = new ArrayList<>();
        for(int i = 0; i<12;i++){
            musicList1.add(music.get(i));
        }
        for(int i = 12; i<24;i++){
            musicList2.add(music.get(i));
        }
        model.addAttribute("musicList1",musicList1);
        model.addAttribute("musicList2",musicList2);
        return "main";
    }
    @RequestMapping("/iframemusic")
    public String iframemusic(){
        return "songs";
    }
    @RequestMapping("/iframecollection")
    public String iframecollection(User user, Model model){
        List<Music> musicList = iSheetService.findMyCollectedMusic(user.getUid());
        model.addAttribute("musicList",musicList);
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
    public String iframepersonal(User user, Model model){
        List<Music> musicList = iSheetService.findMyCollectedMusic(user.getUid());
        List<Sheet> sheetList = iSheetService.fingMyCollectionSheet(user.getUid());
        model.addAttribute("musicList",musicList);
        model.addAttribute("sheetList",sheetList);
        return "personal";
    }

}