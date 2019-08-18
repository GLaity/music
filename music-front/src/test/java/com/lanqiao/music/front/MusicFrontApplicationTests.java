package com.lanqiao.music.front;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.frontservice.ISheetService;
import com.lanqiao.music.server.frontservice.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        System.out.println(iSheetService.searchAll("李四歌单"));
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
