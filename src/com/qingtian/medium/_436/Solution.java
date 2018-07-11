package com.qingtian.medium._436;

import com.qingtian.pojo.Interval;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/7/10
 */
public class Solution {

    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }


    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(0, 1),
                new Interval(3, 4)
        };

        int[] rightInterval = new Solution().findRightInterval(intervals);
        System.out.println(Arrays.toString(rightInterval));
    }
}
