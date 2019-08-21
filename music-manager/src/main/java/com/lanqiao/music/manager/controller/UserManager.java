package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user/")
public class UserManager {

    @Reference
    private IUserService iUserService;
    @GetMapping("list/{num}")
    public String  userList(Model model,@PathVariable Integer num){
        if(num==null){
            num=1;
        }
        //所有数据
        List<User> users =iUserService.getAll();
        //页面展示数据
        List<User> list = new ArrayList<>();
        for(int i =5;i>0;i--){
            if ((5*num-i) < users.size()){
                list.add(users.get(5*num-i));
            }
        }
        //页码
        int a = 0;
        if(users.size()%5==0){
            a=users.size()/5;
        }else {
            a=users.size()/5+1;
        }
        int[] count = new int[a];
        for (int j = 0; j < a; j++){
            count[j] = j+1;
        }

        model.addAttribute("count",count);
        model.addAttribute("size",users.size());
        model.addAttribute("users",list);
        model.addAttribute("a",a);
        return  "admin-list";
    }



    @RequestMapping("update/{id}")
    public String updateUser(@PathVariable int id,Model model){
        User user=iUserService.getUserById(id);
        model.addAttribute("user",user);
        return  "admin-add";
    }
    @RequestMapping("save")
    public String saveUser(User user){
        System.out.println(user.getUdate() instanceof Date);

        if(user.getUid()==null){
            iUserService.saveUserSelective(user);
        }else{
            iUserService.updateUserByPrimaryKeySelective(user);
        }
        return   "redirect:/user/list/1";
    }


    @RequestMapping("delete/{id}")
    public String deleteUserById(@PathVariable int id){
        iUserService.deleteUserById(id);
        return  "redirect:/user/list/1";

    }

    @RequestMapping("deleteAll")
    public String deleteAllUser(ModelMap map, HttpServletRequest request){
        String[] checkbox = request.getParameterValues("checkbox");
        for (String bid : checkbox){
            iUserService.deleteUserById(Integer.valueOf(bid));
        }
        return "redirect:/user/list/1";

    }



    @RequestMapping("search")
    public String searchUser(Date mindate, Date maxdate,Model model){
        List<User> users =iUserService.getAll();
        Iterator iterator =users.iterator();
        List<User> aa = new ArrayList<>();
        while(iterator.hasNext()){
            User user= (User) iterator.next();
            if(user.getUdate().compareTo(maxdate)<1 && user.getUdate().compareTo(mindate)>-1){
                System.out.println(user);
                aa.add(user);
            }
        }
        model.addAttribute("search",aa);
        return  "admin-search";
    }

}
