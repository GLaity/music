package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public String iframegenres(Model model){
        model.addAttribute("allmusic", iMusicService.queryAllMusic());
        model.addAttribute("theme",  iMusicService.queryTheme());
        model.addAttribute("style",  iMusicService.queryStyle());
        model.addAttribute("language",  iMusicService.queryLanguage());
        return "genres";
    }

    @RequestMapping(value = "/iframegenre3/{sortid}")
    @ResponseBody
    public List<Music> sortname3(Model model, @PathVariable Integer sortid ){
        System.out.println(" sortname3" + sortid);
        List<Music> allmusic = iMusicService.queryMusicCondition(3,sortid);
        model.addAttribute("theme",  iMusicService.queryTheme());
        return allmusic;
    }
    @RequestMapping(value = "/iframegenre2/{sortid}")
    @ResponseBody
    public List<Music> sortname2(Model model, @PathVariable Integer sortid ){
        System.out.println(" sortname2" + sortid);
        List<Music> allmusic = iMusicService.queryMusicCondition(2,sortid);
        model.addAttribute("style",  iMusicService.queryStyle());

        return allmusic;
}
    @RequestMapping(value = "/iframegenre1/{sortid}")
    @ResponseBody
    public List<Music> sortname1(Model model, @PathVariable Integer sortid ){
        System.out.println(" sortname1" + sortid);
        List<Music> allmusic = iMusicService.queryMusicCondition(1,sortid);
        model.addAttribute("language",  iMusicService.queryLanguage());

        return allmusic;
    }






    @RequestMapping("/iframemyplaylist")
    public String iframemyplaylist(){
        return "myplaylist";
    }
    @RequestMapping("/iframesearch/{text}")
    public String iframesearch(@PathVariable String text, Model model){
        List<Music> searchNameList = iMusicService.queryMusicByLikename(text);
        model.addAttribute("searchNameList",searchNameList);
        List<Music> searchSingerList = iMusicService.queryMusicByCondition(null,text,null,null,null,null,null);
        model.addAttribute("searchSingerList",searchSingerList);
        return "search";
    }
    @RequestMapping("/iframevideo")
    public String iframevideo(ModelMap map, HttpSession session){
        List<Sheet> sheetList=iSheetService.findAllPublicSheet();
        User user=(User) session.getAttribute("user");
        map.addAttribute("sheets",sheetList);
        map.addAttribute("user",user);
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
    @RequestMapping("/iframeinfo/{id}")
    public String iframeinfo(HttpSession session, @PathVariable Integer id){
        Music music = iMusicService.queryMusicByMId(id);
        List<Music> musics = (List<Music>) session.getAttribute("musics");
        if (musics == null){
            musics = new LinkedList<>();
        }
        if (musics.contains(music)){
            musics.remove(music);
        }
        musics.add(music);
        session.setAttribute("musics",musics);
        return "musicplay";
    }
}