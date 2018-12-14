package com.qingtian.easy._412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/12/14
 * @description
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> reList = new ArrayList<>();
        if (n <= 0)
            return reList;

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                reList.add("FizzBuzz");
            else if (i % 5 == 0)
                reList.add("Buzz");
            else if (i % 3 == 0)
                reList.add("Fizz");
            else
                reList.add(String.valueOf(i));
        }

        return reList;
    }
}
