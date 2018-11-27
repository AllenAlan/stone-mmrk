package com.allen.stone.api.learn.visit;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 23:20
 **/
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}