package com.qingtian.easy._167;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/6/21
 */
public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2)
            return new int[]{};

        int left = 0, right = numbers.length - 1;
        while (left < right) {

            int value = numbers[left] + numbers[right];
            if (value == target) {
                return new int[]{left + 1, right + 1};
            } else if (value < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] twoSum = new Solution1().twoSum(numbers, target);
        System.out.println(Arrays.toString(twoSum));
    }
}
