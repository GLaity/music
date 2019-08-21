package com.lanqiao.music.server;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;
import com.lanqiao.music.server.service.IRadioService;
import com.lanqiao.music.server.service.impl.MusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServerApplicationTests {
    @Autowired
    private IRadioService iRadioService;
    @Autowired
    private MusicService musicService;
    @Test
    public void contextLoads() {

        List<Radio> radis=  iRadioService.getAllRadio();
        System.out.println(radis);
        Music m = new Music();
        m.setMid(1);
        m.setMdate(new Date());
        musicService.modifyMusic(m);
    }

}
