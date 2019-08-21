package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("/music")
public class MusicController {

    @Reference
    private IMusicService musicService;

    @RequestMapping("/list.do/{num}")
    public String musicList(ModelMap map,@PathVariable Integer num){
        if(num==null){
            num=1;
        }
        List<Music> musicList = musicService.getAllMusic();
        Integer size = musicList.size();
        //页面展示数据
        List<Music> list = new ArrayList<>();
        for(int i =10;i>0;i--){
            if ((10*num-i) < size){
                list.add(musicList.get(10*num-i));
            }
        }
        //页码
        int[] count = new int[size/10+1];
        for (int j = 0; j < size/10+1; j++){
            count[j] = j+1;
        }
        map.addAttribute("num",num);
        map.addAttribute("count",count);
        map.addAttribute("size",size);
        map.addAttribute("musicList",list);
        return "music-manage";
    }

    @ResponseBody
    @GetMapping("/delete.do/{mid}")
    public Object deleteMusic(@PathVariable Integer mid){
        Map<String,Object> map = new HashMap<>();
        musicService.removeMusic(mid);
        musicService.removeRadioMusic(mid);
        musicService.removeSheetMusic(mid);
        List<Music> musicList = musicService.getAllMusic();
        map.put("count",musicList.size());
        map.put("msg","删除成功！");
        return map;
    }

    @RequestMapping("/selectdel.do")
    public String selectdelMusic(ModelMap map, HttpServletRequest request){
            String[] checkbox = request.getParameterValues("checkbox");
            if (checkbox != null){
                for (String mid : checkbox){
                    musicService.removeMusic(Integer.valueOf(mid));
                }
            }
            return "redirect:/music/list.do/1";
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
        System.out.println(music.getMdate());
        System.out.println(musicService.getOneMusic(music.getMid()));
        return "redirect:/music/list.do/1";
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

        mv.setViewName("redirect:/music/list.do/1");
        return mv;
    }
}
