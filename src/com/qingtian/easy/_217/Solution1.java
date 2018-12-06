package com.qingtian.easy._217;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/16
 */
public class Solution1 {


    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>(nums.length);
        // 利用set比较
        for(int x:nums){
            if(!set.add(x))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {1,2,3,5,6,8,3,12,24,2};
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);
    }
}
