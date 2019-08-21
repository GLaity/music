package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.frontservice.IUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    @Reference
    private IMusicService iMusicService;
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
    @RequestMapping("/musicDownload/{mid}")
    public ResponseEntity<byte[]> downLoad(@PathVariable Integer mid) throws IOException {
        Music music =iMusicService.queryMusicByMId(mid);
        if (music!=null){
            String mId =mid.toString();
            String mName=music.getMname();
            String musicLoc = "content/songs/1.mp3";
//            String realPath="C:\\Users\\admin\\Desktop\\music-new\\music-front\\src\\main\\resources\\static\\content\\songs\\";
//            String musicLoc =realPath+mId+"\\"+mName+".mp3";
//            String musicLoc=".\\content\\songs\\26\\Battle Symphony.mp3";
//            C:\Users\admin\Desktop\music-new\music-front\src\main\resources\static\content\songs\1\爱情的花样.mp3
            File file =new File(musicLoc);
            byte [] body=null;
            InputStream is=new FileInputStream(file);
            body=new byte[is.available()];
            is.read(body);
            HttpHeaders headers=new HttpHeaders();
            headers.add("Content-Disposition", "attchement;filename=" + mName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", new String(musicLoc.getBytes("UTF-8"), "ISO8859-1"));
            HttpStatus statusCode = HttpStatus.OK;
            ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
            return entity;
        }
        return null;
    }
    @RequestMapping(value = "/addMusicToSheet/{mid}/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> removeMusic(HttpSession session, @PathVariable Integer mid,@PathVariable Integer sid) {
        User user=(User) session.getAttribute("user");
        Integer uid =user.getUid();
        System.out.println(mid+"+"+sid);
        iSheetService.addMusicIntoSheet(sid, mid);
        Map<String,String> map =new HashMap<>();
        map.put("msg","歌曲添加成功");
        return map;
    }

}
