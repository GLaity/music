package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;
import com.lanqiao.music.server.service.IRadioService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/radio")
public class RadioController {

    @Reference
    private IRadioService radioService;

    @RequestMapping("/list.do")
    public String musicList(ModelMap map){
        List<Radio> radioList = radioService.getAllRadio();
        map.addAttribute("size",radioList.size());
        map.addAttribute("radioList",radioList);
        return "radio-list";
    }

    @GetMapping("/select.do/{rid}")
    public String musicList(ModelMap map, @PathVariable Integer rid){
        List<Music> musicList = radioService.getMusicByRid(rid);
        map.addAttribute("size",musicList.size());
        map.addAttribute("musicList",musicList);
        return "radio-music-list";
    }

    @GetMapping("/find.do")
    public String findList(@RequestParam(value = "attr") String attr,@RequestParam(value = "key") Object key, ModelMap map){
        List<Radio> radioList = radioService.findRadioByAttr(attr,key);
        map.addAttribute("size",radioList.size());
        map.addAttribute("musicList",radioList);
        return "radio-list";
    }

}
