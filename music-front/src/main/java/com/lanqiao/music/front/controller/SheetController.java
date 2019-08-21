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
import java.util.Set;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class SheetController {
    @Reference
    private ISheetService iSheetService;
    @Reference
    private IUserService iUserService;
    @RequestMapping("/iframeplay-list")
    public String iframeplaylist(ModelMap map, HttpSession session){
        List<Sheet> sheetList=iSheetService.findAllPublicSheet();
        User user=(User) session.getAttribute("user");
        map.addAttribute("sheets",sheetList);
        map.addAttribute("user",user);
        return "play-list";
    }
    @RequestMapping("/playlistent/{sid}")
    public String Iplaylistenter(ModelMap map, @PathVariable Integer sid, HttpSession session) {
        Integer creatUid=iSheetService.getAuthorId(sid);
        User creatUser=iUserService.findUserByUid(creatUid);
        Sheet sheet =iSheetService.findSheetBySid(sid);
        List<Music> musicList=sheet.getMusicList();
        User user = (User) session.getAttribute("user");
        int flag = 0;
        if (user != null){
            user = iUserService.getCreateSheet(user.getUid());
            if(user.getUCollectionSheet()==null){
                flag=0;
            }else{
                Set<Sheet> sheetList = user.getUCollectionSheet();
                for(Sheet sheeta : sheetList){
                    if(sheeta.getSid()== sid){
                        flag = 1;
                        break;
                    }
                }
            }
            map.addAttribute("user",user);
        }
        map.addAttribute("sheet",sheet);
        map.addAttribute("creatUserName",creatUser.getUname());
        map.addAttribute("mid",musicList.get(0).getMid());
        map.addAttribute("mname",musicList.get(0).getMname());
        map.addAttribute("flag",flag);
        return "play-list-enter";
    }
    @RequestMapping(value = "/addSheet/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> CollectionSheet(HttpSession session, @PathVariable Integer sid){
        Map<String,String> map =new HashMap<>();
        if (sid == null){
            map.put("msg","请登录");
        }else {
            User user=(User) session.getAttribute("user");
            Integer uid =user.getUid();
            iSheetService.addOtherSheet(uid,sid);
            map.put("msg","歌单添加成功");
        }
        return map;
    }
    @RequestMapping(value = "/removeSheet/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> removeSheet(HttpSession session, @PathVariable Integer sid){
        Map<String,String> map =new HashMap<>();
        User user=(User) session.getAttribute("user");
        iSheetService.removeOtherSheet(user.getUid(),sid);
        map.put("msg","歌单取消收藏成功");
        return map;
    }
}
