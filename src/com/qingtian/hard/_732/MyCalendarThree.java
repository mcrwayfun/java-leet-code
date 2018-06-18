package com.qingtian.hard._732;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/18
 */
public class MyCalendarThree {

    private TreeMap<Integer, Integer> counts = new TreeMap<>();

    public MyCalendarThree() {

    }

    public int book(int start, int end) {

        counts.put(start, counts.getOrDefault(start, 0) + 1);
        counts.put(end, counts.getOrDefault(end, 0) - 1);

        int count = 0, curr = 0;
        for (int index : counts.values()) {
            count = Math.max(count, curr += index);
        }

        return count;
    }

    public static void main(String[] args) {
        MyCalendarThree demo = new MyCalendarThree();
        demo.book(10,20);
        demo.book(50,60);
        demo.book(10,40);
        demo.book(5,15);
        demo.book(5,10);
        demo.book(25,55);
    }

}
