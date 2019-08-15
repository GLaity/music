package com.lanqiao.music.server;

import com.lanqiao.music.server.dao.BoughtMapper;
import com.lanqiao.music.server.service.IBoughtService;
import com.lanqiao.music.server.service.impl.BoughtService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServerApplicationTests {

    @Autowired
    private IBoughtService iBoughtService;
    @Test
    public void contextLoads() {

        iBoughtService.addBought(1,"充值",10.0);
    }

}
