package com.shane.init.controller;

import com.shane.init.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ShaneHolmes
 * @date 2020/4/23 - 17:14
 * 功能描述：
 */
@Controller
public class IndexController {

    //testUDE测试用户自定义异常./user?user=xxx模拟抛出一个异常
    @ResponseBody
    @RequestMapping("/user")
    public String testUDE(@RequestParam("user") String user){
        if(user.equals("xxx")){
            throw new UserNotExistException();
        }
        return "testUDE";
    }
}
