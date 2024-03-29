package com.lanqiao.music.front;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.frontservice.IUserService;
import com.lanqiao.music.server.pojo.Music;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicFrontApplicationTests {
    @Reference
    private IUserService iUserService;
    @Reference
    private IMusicService iMusicService;

    @Test
    public  void subMonth() throws ParseException {
//        System.out.println(iMusicService.queryMusicByLikename("初"));
        List<Music> searchSingerList = iMusicService.queryMusicByCondition(null,"h",null,null,null,null,null);
        System.out.println(searchSingerList);
    }

}
