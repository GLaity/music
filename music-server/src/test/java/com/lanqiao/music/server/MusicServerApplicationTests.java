package com.lanqiao.music.server;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;
import com.lanqiao.music.server.service.IRadioService;
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
    private IRadioService iRadioService;
    @Test
    public void contextLoads() {

        List<Radio> radis=  iRadioService.getAllRadio();
        System.out.println(radis);
    }

}
