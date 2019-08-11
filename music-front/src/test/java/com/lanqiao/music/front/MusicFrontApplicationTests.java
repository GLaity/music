package com.lanqiao.music.front;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicFrontApplicationTests {
    @Reference
    private IUserService iUserService;
    @Test
    public void contextLoads() {
        System.out.println(iUserService.login("李四","123456"));
    }

}
