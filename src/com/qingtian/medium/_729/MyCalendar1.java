package com.qingtian.medium._729;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/06/17
 */
public class MyCalendar1 {

    private List<int[]> calerdar;

    public MyCalendar1() {
        calerdar = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        for (int[] val : calerdar)
            if (Math.max(val[0], start) < Math.min(val[1], end))
                return false;

        calerdar.add(new int[]{start, end});
        return true;
    }


}
