package com.qingtian.easy._167;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/21
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2)
            return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            int value = target - numbers[i];
            if (!map.containsKey(value)) {
                map.put(numbers[i], i);
            } else {
                return new int[]{map.get(value) + 1, i + 1};
            }

        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] twoSum = new Solution().twoSum(numbers, target);
        System.out.println(Arrays.toString(twoSum));
    }
}
