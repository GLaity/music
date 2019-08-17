package com.lanqiao.music.server;

import com.lanqiao.music.server.dao.BoughtMapper;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IBoughtService;
import com.lanqiao.music.server.service.ISheetService;
import com.lanqiao.music.server.service.IUserService;
import com.lanqiao.music.server.service.impl.BoughtService;
import com.lanqiao.music.server.service.impl.SheetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServerApplicationTests {
    @Test
    public void contextLoads() {

    }
}
