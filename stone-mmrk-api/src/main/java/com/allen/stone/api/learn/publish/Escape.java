package com.allen.stone.api.learn.publish;


import com.allen.stone.common.annotation.NotRecommend;
import com.allen.stone.common.annotation.NotThreadSafe;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/23 23:05
 **/
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
