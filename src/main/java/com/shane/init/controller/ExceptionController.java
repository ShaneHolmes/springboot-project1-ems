package com.shane.init.controller;

import com.shane.init.exception.UserNotExistException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneHolmes
 * @date 2020/4/28 - 23:17
 * 功能描述：用户自定义异常处理控制器，用户自定义异常在exception里定义
 */
@ControllerAdvice
public class ExceptionController {

    //@ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e,
                                  HttpServletRequest request){

        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
        map.put("code","user_not_exist");
        map.put("message",e.getMessage());
        //要想将自己的数据传出去，需要放到request域中
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
