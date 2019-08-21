package com.lanqiao.music.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IAdviceService;
import com.lanqiao.music.server.service.IBoughtService;
import com.lanqiao.music.server.service.IMusicService;
import com.lanqiao.music.server.service.IRadioService;
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
    private IRadioService radioService;

    @Test
    public void contextLoads() {
        System.out.println(radioService.findRadioByAttr("1","1"));
    }

}
