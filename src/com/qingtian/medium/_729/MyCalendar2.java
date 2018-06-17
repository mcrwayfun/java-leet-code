package com.qingtian.medium._729;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/17
 */
public class MyCalendar2 {

    TreeMap<Integer,Integer> calendar;

    public MyCalendar2() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> floorEntry = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = calendar.ceilingEntry(start);

        if(floorEntry != null && floorEntry.getValue() > start)
            return false;

        if(ceilingEntry != null && ceilingEntry.getKey() < end)
            return false;

        calendar.put(start,end);
        return true;
    }
}
