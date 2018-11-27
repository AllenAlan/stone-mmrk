package com.allen.stone.api.learn.immutable;

import com.allen.stone.common.annotation.NotThreadSafe;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/25 20:20
 **/
@NotThreadSafe
public class ImmutableTest {

    private final static Integer a = 1;

    private final static String b = "2";

    private final static Map<Integer, Integer> map = Maps.newHashMap();


    static {
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
    }

    public static void main(String[] args) {
//        a = 2;
//        map = Maps.newHashMap();
        map.put(1,5);
        System.out.println(map);
    }

    private void test(final int a){
//        a = 1;
    }





}
