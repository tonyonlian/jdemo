package com.tunyl.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author create by Tunyl on 2019/12/19
 * @version 1.0
 */
public class LinkedListTest {
    public static void main(String[] args) {
        //LIFO 栈
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());
        //FIFO 队列
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(Objects.isNull(list));
    }
}
