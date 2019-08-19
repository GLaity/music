package com.lanqiao.music.front;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicFrontApplicationTests {
    @Reference
    private IUserService iUserService;
    @Test
    public void contextLoads() {
//        System.out.println(iUserService.findUserByUid(1));
//        System.out.println(iUserService.login("张三","123456"));
        User user = new User();
        user.setUid(1);
        user.setUname("李四");
        iUserService.modifyUser(user);
    }

}
