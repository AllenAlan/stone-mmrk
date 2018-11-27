package com.allen.stone.api.learn.java8;

/**
 * Node 接点
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/18 21:43
 **/
public class Node {
    private Node next;
    private int value;

    public Node() {
        next = null;
    }

    public Node(int o) {
        value = o;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
