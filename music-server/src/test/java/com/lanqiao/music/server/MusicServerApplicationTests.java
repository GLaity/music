package com.lanqiao.music.server;

import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.pojo.Music;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServerApplicationTests {

    @Autowired
    private IMusicService iMusicService;
    @Test
    public void contextLoads() {
//        System.out.println(iMusicService.queryMusicByLikename("凉凉"));

    }
}
