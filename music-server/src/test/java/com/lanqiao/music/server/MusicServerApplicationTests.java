package com.lanqiao.music.server;

import com.lanqiao.music.server.dao.BoughtMapper;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IBoughtService;
import com.lanqiao.music.server.service.ISheetService;
import com.lanqiao.music.server.service.IUserService;
import com.lanqiao.music.server.service.impl.BoughtService;
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
    private ISheetService iSheetService;
    @Autowired
    private IUserService iUserService;

    @Test
    public void contextLoads() {
//        User user = new User();
//        user.setUname("shazi");
//        user.setUpwd("111");
//        user.setUbalance(0.0);
//        iUserService.register(user);
//        System.out.println(user.getUid());

//        System.out.println(iSheetService.findAllSheet());
//        System.out.println(iUserService.findUserByUid(1));

//        List<Sheet> sheetList = iSheetService.findAllSheet();
//        for (Sheet sheet : sheetList) {
//            System.out.println(sheet);
//        }
    }
}
