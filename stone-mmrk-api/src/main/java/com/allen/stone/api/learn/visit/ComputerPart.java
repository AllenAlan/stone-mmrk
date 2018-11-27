package com.allen.stone.api.learn.visit;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 23:19
 **/
public interface ComputerPart {
   void accept(ComputerPartVisitor computerPartVisitor);
}