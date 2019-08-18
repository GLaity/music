package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.MusicJson;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MusicController {
    @Reference
    private IMusicService iMusicService;

//
//    @RequestMapping("/music")
//    public String findAllMusic(Model model){
//        List<Music> musicList = iMusicService.queryAllMusic();
//        model.addAttribute("musicList",musicList);
//        return "musicplay";
//    }

//    @Reference
//    private ISheetService iSheetService;
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

    @RequestMapping("/getMusic")
    @ResponseBody
    public List<MusicJson> getMusic(HttpSession session){
        List<MusicJson> musicJsons = (List<MusicJson>) session.getAttribute("musicJsons");
        if (musicJsons == null) {
            MusicJson musicJson = new MusicJson();
            musicJson.setTitle("儿歌");
            musicJson.setArtist("老王");
            musicJson.setMp3("./content/songs/儿歌.mp3");
            musicJson.setPoster("./content/songs/儿歌.jpg");

            musicJsons = new LinkedList<>();
            musicJsons.add(musicJson);
            session.setAttribute("musicJsons",musicJsons);
        }
        return musicJsons;
    }
    @RequestMapping("/playMusic/{id}")
    @ResponseBody
    public List<MusicJson> playMusic(HttpSession session, @PathVariable Integer id){
        Music music = iMusicService.queryMusicByMId(id);
        MusicJson musicJson = new MusicJson();
        musicJson.setTitle(music.getMname());
        musicJson.setArtist(music.getMsinger());
        musicJson.setMp3(music.getMloc());
        musicJson.setPoster("");
        List<MusicJson> musicJsons = (List<MusicJson>) session.getAttribute("musicJsons");
        if (musicJsons != null) {
            //添加元素到栈顶
            musicJsons.add(0,musicJson);
        }
        session.setAttribute("musicJsonList",musicJsons);
        return musicJsons;
    }
}
