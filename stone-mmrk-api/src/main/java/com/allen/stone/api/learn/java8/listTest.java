package com.allen.stone.api.learn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/18 12:00
 **/
public class listTest {

    public void addl(List<List> allGroups, List group, Integer n){
        if (n <= 0){
            return;
        }
        n--;
        allGroups.add(group);
        addl(allGroups, group, n);

    }



    public static void main(String[] args) {
        List allGroups = new ArrayList<List>();
        listTest test = new listTest();
        test.addl(allGroups, Arrays.asList(1, 2, 3, 4), 10);
        System.out.println(allGroups.toString());

    }
}
