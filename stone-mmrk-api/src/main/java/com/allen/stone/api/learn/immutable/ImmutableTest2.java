package com.allen.stone.api.learn.immutable;

import com.allen.stone.common.annotation.ThreadSafe;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.Map;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/25 20:20
 **/
@ThreadSafe
public class ImmutableTest2 {

    private static Map<Integer, Integer> map;

    static {
        map = Maps.newHashMap();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 5);
        System.out.println(map);
    }


}
