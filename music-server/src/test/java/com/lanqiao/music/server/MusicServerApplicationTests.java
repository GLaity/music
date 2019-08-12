package com.lanqiao.music.server;

import com.lanqiao.music.server.dao.SheetMapper;
import com.lanqiao.music.server.dao.UserMapper;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@MapperScan("com.lanqiao.music.server.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServerApplicationTests {
    @Autowired
    private SheetMapper sheetMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() throws SQLException {
//        System.out.println("-----------");
//        List<Sheet> sheets =sheetMapper.searchAll();
//        System.out.println(sheets);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);

    }

}
