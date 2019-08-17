package com.lanqiao.music.front;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.ISheetService;
import com.lanqiao.music.server.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicFrontApplicationTests {
    @Reference
    private IUserService iUserService;
    @Reference
    private ISheetService iSheetService;
    @Test
    public void contextLoads() {
//        System.out.println();
//        System.out.println(iUserService.login("李四","123456"));
        //System.out.println(iSheetService.searchAll("李四歌单"));
        Sheet sheet =new Sheet();
        sheet.setSname("test");
        sheet.setScontext("test");
//        Music music =new Music();
//        music.setMid(1);
//        List<Music> musicList =new ArrayList<>();
//        musicList.add(music);
//        sheet.setMusicList(musicList);
        User user =new User();
        user.setUid(3);
        user.setUname("abc");
        iSheetService.initSheet(sheet,user,1);
        System.out.println(iSheetService.searchAll());
//        System.out.println(iSheetService.searchAll("test"));
    }
    @Test
    public  void subMonth() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        Integer a=2;
        rightNow.add(Calendar.MONTH, a);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        Date d = sdf.parse(reStr);
        System.out.println(reStr);
        System.out.println(d);
//        return d;
    }

}
