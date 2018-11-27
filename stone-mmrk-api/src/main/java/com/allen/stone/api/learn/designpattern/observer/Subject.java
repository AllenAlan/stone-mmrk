package com.allen.stone.api.learn.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:55
 **/
public class Subject {

    private String state;

    private List<Observer> observers = new ArrayList();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        radio();

    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void radio(){
        for (Observer observer:observers) {
            observer.update();
        }

    }


}
