package com.allen.stone.api.learn.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 递归
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/18 10:42
 **/
public class RecursionTest{

    private static final Logger logger = LoggerFactory.getLogger(RecursionTest.class);

    /**
     * @Description: 罗列一个集合 n个元素的组合
     * @param group 组合结果, 原始集合, 组合长度
     */
    public void groupCreater(List<List> allGroup, List group, List list, Integer len) {

        if (len <= 0) {
            System.out.println(group.toString());

            allGroup.add(group);
            System.out.println(allGroup.toString());
            return;
        }

        // 考虑list为空的情况
        if (list.isEmpty()) {
            return;
        }

        // 假设选取第一个元素
        group.add(list.get(0));
        groupCreater(allGroup, group, list.subList(1, list.size()), len - 1);

        // 假设没有选取第一个元素
        group.remove(group.size() - 1);
        groupCreater(allGroup, group, list.subList(1, list.size()), len);

    }

    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();
        List allGroups = new ArrayList<ArrayList>();

//        System.out.println("-----------------");
//        test.groupCreater(allGroups,new ArrayList<Integer>(), new ArrayList<Integer>(), 0);
//        System.out.println(JSON.toJSONString(allGroups));
//        allGroups.clear();
//
        System.out.println("-----------------");
        test.groupCreater(allGroups, new ArrayList<Integer>(), Arrays.asList(1, 2, 3, 4), 2);
        System.out.println(allGroups.toString());

//        System.out.println("-----------------");
//        test.groupCreater(allGroups, new ArrayList<Integer>(), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5);
//        System.out.println(JSON.toJSONString(allGroups));
//        allGroups.clear();


    }
}
