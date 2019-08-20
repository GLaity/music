package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.frontservice.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SheetController {
    @Reference
    private ISheetService iSheetService;
    @Reference
    private IUserService iUserService;
    @RequestMapping("/iframeplay-list")
    public String iframeplaylist(ModelMap map){
        List<Sheet> sheetList=iSheetService.findAllPublicSheet();
        System.out.println(sheetList.get(0).getMusicList().get(0).getMid());
        map.addAttribute("sheets",sheetList);
//        return "play-list-enter";
        return "play-list";
    }
    @RequestMapping("/playlistent/{sid}")
    public String Iplaylistenter(ModelMap map, @PathVariable Integer sid)
    {
        Sheet sheet =iSheetService.findSheetBySid(sid);
        List<Music> musicList=sheet.getMusicList();
        Integer uid =iSheetService.findUser(sid);
        Integer mid =musicList.get(0).getMid();
        String mname=musicList.get(0).getMname();
        User user=iUserService.findUserByUid(uid);
        map.addAttribute("sheet",sheet);
        map.addAttribute("userName",user.getUname());
        map.addAttribute("mid",mid);
        map.addAttribute("mname",mname);
        return "play-list-enter";
    }

}
