package com.qingtian.medium._731;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/17
 */
public class MyCalendarTwo {

    private List<int[]> overlaps = new ArrayList<>();
    private List<int[]> booked = new ArrayList<>();

    public boolean book(int start, int end) {

        for (int[] val : overlaps)
            if (Math.max(start, val[0]) < Math.min(end, val[1]))
                return false;

        for (int[] val : booked) {
            int ss = Math.max(start, val[0]);
            int ee = Math.min(end, val[1]);
            if (ss < ee)
                overlaps.add(new int[]{ss, ee});
        }

        booked.add(new int[]{start, end});
        return true;
    }


}
