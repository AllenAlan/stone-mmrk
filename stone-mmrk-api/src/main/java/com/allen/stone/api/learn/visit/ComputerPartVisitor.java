package com.allen.stone.api.learn.visit;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 23:19
 **/
public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}