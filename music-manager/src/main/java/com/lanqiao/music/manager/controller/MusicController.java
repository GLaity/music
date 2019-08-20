package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/music")
public class MusicController {

    @Reference
    private IMusicService musicService;

    @RequestMapping("/list.do")
    public String musicList(ModelMap map){
//        PageHelper.startPage(pageNum,5);
        List<Music> musicList = musicService.getAllMusic();
//        PageInfo<Music> page = new PageInfo<>(musicList);

        map.addAttribute("size",musicList.size());
//        map.addAttribute("page",page);
        map.addAttribute("musicList",musicList);
        return "music-manage";
    }

    @GetMapping("/delete.do/{mid}")
    public ModelAndView deleteMusic(@PathVariable Integer mid){
        ModelAndView mv = new ModelAndView();
        musicService.removeMusic(mid);
        musicService.removeRadioMusic(mid);
        musicService.removeSheetMusic(mid);
        mv.setViewName("redirect:/music/list.do");
        return mv;
    }

    @GetMapping("/select.do/{mid}")
    public String getOneMusic(@PathVariable Integer mid,ModelMap map){
        Music music = musicService.getOneMusic(mid);
        map.addAttribute("musicList",music);
        return "music-edit";
    }

    @RequestMapping("/update.do")
    public String updateMusic(Music music){
        musicService.modifyMusic(music);
        return "redirect:/music/list.do";
    }

    @RequestMapping("/upload.do")
    public ModelAndView singleFileUpload(Music m, Model model, HttpSession session) throws IOException {
        ModelAndView mv = new ModelAndView();

//        音乐目录
        List<MultipartFile> imgs = new ArrayList<>();
        imgs.add(m.getImg1());
        imgs.add(m.getImg2());
        imgs.add(m.getImg3());
        File newFile = null;
        for (MultipartFile img : imgs){
            if (!img.isEmpty()){
                String originalFilename = img.getOriginalFilename();
//                uploadPath = "/tar/uploadfile";
//                String realPath = session.getServletContext().getRealPath("/")+uploadPath;
                String realPath = "D:/web/idea/music/img";
                File uploadDir = new File(realPath);
                if (!uploadDir.exists()){
                    uploadDir.mkdirs();
                }
                newFile = new File(uploadDir,originalFilename);
                System.out.println(originalFilename);
                img.transferTo(newFile);
            }else {
                mv.setViewName("redirect:/404.html");
                return mv;
            }
        }


//        将音乐信息添加到数据库
        Music music = new Music();
        music.setMname(m.getMname());
        music.setMsinger(m.getMsinger());
        music.setMcontext(m.getMcontext());
        music.setMalbum(m.getMalbum());
        music.setMlevel(m.getMlevel());
        music.setMtheme(m.getMtheme());
        music.setMstyle(m.getMstyle());
        music.setMlanguage(m.getMlanguage());
        music.setMprice(m.getMprice());
        music.setMloc(String.valueOf(newFile));
        music.setMdate(m.getMdate());
        musicService.addMusic(music);

        mv.setViewName("redirect:/music/list.do");
        return mv;
    }
}
