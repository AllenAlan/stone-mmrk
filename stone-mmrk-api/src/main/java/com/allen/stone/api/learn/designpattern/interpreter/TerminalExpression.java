package com.allen.stone.api.learn.designpattern.interpreter;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 21:54
 **/
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}