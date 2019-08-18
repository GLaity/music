package com.lanqiao.music.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IMusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicManagerApplicationTests {

    @Reference
    private IMusicService musicService;

    @Test
    public void contextLoads() {

        Music music = musicService.getOneMusic(1);
        System.out.println(music);
    }

}
