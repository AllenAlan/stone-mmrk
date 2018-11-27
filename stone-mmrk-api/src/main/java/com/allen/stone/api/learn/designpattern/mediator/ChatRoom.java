package com.allen.stone.api.learn.designpattern.mediator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:30
 **/
import java.util.Date;

public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + " [" + user.getName() +"] : " + message);
    }
}