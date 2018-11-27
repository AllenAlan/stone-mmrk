package com.allen.stone.api.learn.publish;

import com.allen.stone.common.annotation.NotThreadSafe;

import java.util.Arrays;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/23 22:59
 **/
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};
    private String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println(Arrays.toString(unsafePublish.getStates()));


        unsafePublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsafePublish.getStates()));


    }

}
