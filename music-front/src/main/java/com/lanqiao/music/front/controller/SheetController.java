package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.frontservice.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value = {"user"},types = {User.class})
public class SheetController {
    @Reference
    private ISheetService iSheetService;
    @Reference
    private IUserService iUserService;
    @RequestMapping("/iframeplay-list")
    public String iframeplaylist(ModelMap map){
        List<Sheet> sheetList=iSheetService.findAllPublicSheet();
        for (Sheet sheet:sheetList){
            sheet.setType(1);
        }
        System.out.println(sheetList);
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
    @RequestMapping(value = "/addSheet/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> CollectionSheet(HttpSession session, @PathVariable Integer sid){
        Map<String,String> map =new HashMap<>();
        User user=(User) session.getAttribute("user");
        Integer uid =user.getUid();
        iSheetService.addOtherSheet(uid,sid);
        map.put("msg","歌单添加成功");
        return map;
    }

}
