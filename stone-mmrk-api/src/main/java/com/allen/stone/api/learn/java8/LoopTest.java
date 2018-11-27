package com.allen.stone.api.learn.java8;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/18 21:43
 **/
public class LoopTest {

    public Node removeNode(Node head, int nodeValue) {
        Node virtual = new Node();
        virtual.setNext(head);
        head = virtual;
        Node prev = head;
        while (prev.getNext()!= null){
            if(prev.getNext().getValue()==nodeValue){
                prev.setNext(prev.getNext().getNext());
            }else{
                prev = prev.getNext();
            }
        }
        return head.getNext();
    }


    public Node createLinkedNodelist(List<Integer> list) {
        if (list.isEmpty()){
            return null;
        }
        Node first = new Node(list.get(0));
        Node next = createLinkedNodelist(list.subList(1, list.size()));
        first.setNext(next);
        return first;
    }


    public static void main(String[] args) {
        LoopTest test = new LoopTest();
        Node node = test.createLinkedNodelist(Arrays.asList(3, 3, 2, 3, 4, 3, 5, 6));
        node = test.removeNode(node, 3);
        System.out.println(JSON.toJSONString(node));
    }


}
