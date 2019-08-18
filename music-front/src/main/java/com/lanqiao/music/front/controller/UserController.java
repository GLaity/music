package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.frontservice.IBoughtService;
import com.lanqiao.music.server.frontservice.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class UserController {

    @Reference
    private IUserService iUserService;
    @Reference
    private IBoughtService iBoughtService;

    @RequestMapping("/")
    public String init(){
        return "index";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }

    @RequestMapping("/topersonal")
    public String topersonal(){
        return "personal";
    }

//    充值
    @RequestMapping("/torecharge")
    public String recharge(){
        return "recharge";
    }
    //冲会员
    @RequestMapping("/tovip")
    public String tovip(){
        return "member";
    }
    //冲会员



    @RequestMapping("/login")
    public String loginCheck(String uname, String upwd, Model model){
        User user = iUserService.login(uname,upwd);
        if (user != null){
            model.addAttribute("user",user);
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/money")
    public String rechargeMoney(@ModelAttribute("user")User user,Double money){
        user.setUbalance((user.getUbalance()+money));
        iUserService.modifyUser(user);
        iBoughtService.addBought(user.getUid(),"充值",money);
        return "personal";
    }
    @RequestMapping("/vip")
    public String vip(@ModelAttribute("user") User user, Integer mouth, Model model){
        if(user.getUbalance()>=(mouth*10.0)){
            if(user.getVdate()!=null){
                user.setVdate(subMonth(user.getVdate(),mouth));
            }else {
                user.setVdate(subMonth(new Date(),mouth));
            }
            user.setUbalance((user.getUbalance()-(mouth*10.0)));

            iUserService.rechargeVip(user, mouth);
            iBoughtService.addBought(user.getUid(),"充值会员",mouth*10.0);
            model.addAttribute("user",user);
            model.addAttribute("msg","充值会员成功");
            return "personal";
        }else {
            model.addAttribute("msg","余额不足请充值");
            return "recharge";
        }
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(String username){
        User user = iUserService.findUserByName(username);
        String msg= "";
        if(user!=null){
            msg="0";
        }
        return msg;
    }
    @RequestMapping("/register")
    public String register(String username,String password){
        User user = new User();
        user.setUname(username);
        user.setUpwd(password);
        user.setUbalance(0.0);
        iUserService.register(user);
        return "login";
    }
    @RequestMapping("/out")
    public String out(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/save")
    public String save(User user){
        iUserService.modifyUser(user);
        return "personal";
    }
    //增加一个月
    public  Date subMonth(Date date,Integer mouth){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, mouth);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        Date d = null;
        try {
            d = sdf.parse(reStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
