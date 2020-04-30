package com.shane.init.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ShaneHolmes
 * @date 2020/4/26 - 12:37
 * 功能描述：
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session){

        if(!StringUtils.isEmpty(username) && "123456".equals(password)){//登录成功
            session.setAttribute("loginUser",username);
//            System.out.println(username+" "+password);
            return "redirect:/main.html";
        }else {//登陆失败
            map.put("msg","用户名或密码错误！");
            return "login";
        }

    }
}
