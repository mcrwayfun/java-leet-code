package com.qingtian.easy._001;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/20
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sub = target - nums[i];
            if(map.containsKey(sub))
                return new int[]{map.get(sub),i};
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 18;
        int[] twoSum = new Solution1().twoSum(nums, target);
        for(int x:twoSum) System.out.printf(x + " ");
    }
}
