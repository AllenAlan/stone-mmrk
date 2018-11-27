package com.allen.stone.api.learn.designpattern.iterrator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:13
 **/
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for(Iterator<String> iter = namesRepository.getIterator(); iter.hasNext();){
            String name = iter.next();
            System.out.println("Name : " + name);
        }
    }
}