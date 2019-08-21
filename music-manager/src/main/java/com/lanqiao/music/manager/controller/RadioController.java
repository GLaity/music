package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;
import com.lanqiao.music.server.service.IRadioService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    @ResponseBody
//    @GetMapping("/delete.do/{rid}")
//    public Object deleteRadio(@PathVariable Integer rid){
////        Map<String,Object> map = new HashMap<>();
////        radioService.
////        List<Bought> boughtList = boughtService.getAllBought();
////        map.put("count",boughtList.size());
////        map.put("msg","删除成功！");
//     return map;
//    }

    @GetMapping("/find.do")
    public String findList(@RequestParam(value = "attr") String attr,@RequestParam(value = "key") String key, ModelMap map){
        System.out.println(attr+key);
        List<Radio> radioList = radioService.findRadioByAttr(attr,key);
        map.addAttribute("size",radioList.size());
        map.addAttribute("musicList",radioList);
        return "radio-list";
    }

}
