package com.shane.init.exception;

/**
 * @author ShaneHolmes
 * @date 2020/4/28 - 23:11
 * 功能描述：用户自定义异常
 */
public class UserNotExistException extends RuntimeException{

    //Alt+Insert生成构造器
    public UserNotExistException() {
        super("用户不存在！");
    }
}
