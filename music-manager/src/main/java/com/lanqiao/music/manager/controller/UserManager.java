package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserManager {
    @Reference
    private IUserService iUserService;
    @RequestMapping("list")
    public String  userList(Model model){

        List<User> users =iUserService.getAll();
        System.out.println(users);
        model.addAttribute("users",users);
        return  "hello";
    }

}
