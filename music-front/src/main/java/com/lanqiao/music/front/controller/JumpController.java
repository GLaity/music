package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Music> musicList1 = iMusicService.queryAllMusic();

        List<Music> musicList=new ArrayList<>();
        for(int i = 0; i<12;i++){
            musicList.add(musicList1.get(i));
        }
        model.addAttribute("musicList",musicList);
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
    @RequestMapping("/iframesearch/{text}")
    public String iframesearch(@PathVariable String text, Model model){
        List<Music> searchList = iMusicService.queryMusicByLikename(text);
        model.addAttribute("searchList",searchList);
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