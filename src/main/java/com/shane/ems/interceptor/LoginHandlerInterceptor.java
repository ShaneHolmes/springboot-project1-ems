package com.shane.ems.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ShaneHolmes
 * @date 2020/4/26 - 13:55
 * 功能描述：登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        if(loginUser == null){//未登录，返回登录页
            //设置错误消息
            request.setAttribute("unAuthorized","没有访问权限，请先登录！");
            //获取转发器，将请求和响应转发出去
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else {//登陆成功,放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
