package com.allen.stone.api.learn.designpattern.mediator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:30
 **/
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}