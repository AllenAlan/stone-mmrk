package com.allen.stone.api.learn.immutable;

import com.allen.stone.common.annotation.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import io.swagger.models.auth.In;

import java.util.Collections;
import java.util.Map;
import java.util.Queue;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/25 20:20
 **/
@ThreadSafe
public class ImmutableTest3 {

    private static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private static ImmutableSet set = ImmutableSet.copyOf(list);

    private static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1,2);

    private static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1,2).put(3,4).build();

    public static void main(String[] args) {
//        list.add(4);
//        map.put(3, 5);
//        map2.put(3, 5);
        System.out.println(list);
        System.out.println(map);
        System.out.println(map2);

    }


}
