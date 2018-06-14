package com.qingtian.medium._729;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/14
 */
public class MyCalendar {



    // TreeMap<Integer, Integer> tmap = new TreeMap<>();
    // public MyCalendar() {
    //
    // }
    //
    // public boolean book(int start, int end) {
    //
    //     Map.Entry<Integer, Integer> floorEntry = tmap.floorEntry(start);
    //     Map.Entry<Integer, Integer> ceilingEntry = tmap.ceilingEntry(start);
    //
    //     if (floorEntry != null && floorEntry.getValue() > start)
    //         return false;
    //
    //     if (ceilingEntry != null && ceilingEntry.getKey() < end)
    //         return false;
    //
    //     tmap.put(start, end);
    //     return true;
    // }

    TreeMap tm;

    public MyCalendar() {
        tm = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> entry = tm.lowerEntry(end);
        if (entry != null && entry.getValue() > start) return false;
        tm.put(start, end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        boolean book = calendar.book(10, 20);
        System.out.println("first:(10,20) " + book);
        boolean book1 = calendar.book(5, 35);
        System.out.println("second:(5,35) " + book1);

    }
}
