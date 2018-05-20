package com.qingtian.explore._001;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/20
 */
public class Solution {


    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;
        int[] twoSum = new Solution().twoSum(nums, target);
        for(int x:twoSum) System.out.printf(x + " ");
    }
}
