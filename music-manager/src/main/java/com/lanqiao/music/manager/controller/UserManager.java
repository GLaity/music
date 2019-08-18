package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserManager {


    @Reference
    private IUserService iUserService;
    @RequestMapping("list")
    public String  userList(Model model){

        List<User> users =iUserService.getAll();
        model.addAttribute("size",users.size());
        model.addAttribute("users",users);
        return  "admin-list";
    }



    @RequestMapping("update/{id}")
    public String updateUser(@PathVariable int id,Model model){
        User user=iUserService.getUserById(id);
        model.addAttribute("user",user);
        return  "admin-add";
    }
    @RequestMapping("save")
    public String saveUser(User user, HttpServletRequest req){
        if(user.getUid()==null){
            iUserService.saveUserSelective(user);
        }else{
            iUserService.updateUserByPrimaryKeySelective(user);
        }
        return   "redirect:/user/list";
    }


    @RequestMapping("delete/{id}")
    public String deleteUserById(@PathVariable int id){
        iUserService.deleteUserById(id);
        return  "redirect:/user/list";

    }


}
