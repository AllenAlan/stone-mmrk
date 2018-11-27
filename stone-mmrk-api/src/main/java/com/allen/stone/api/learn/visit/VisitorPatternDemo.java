package com.allen.stone.api.learn.visit;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 23:23
 **/
public class VisitorPatternDemo {
    public static void main(String[] args) {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}