package com.qingtian.easy._026;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/14
 */
public class Solution1 {

    public int removeDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);
        for (int num : nums) {
            System.out.println(num);
        }
        return set.size();
    }

    public static void main(String[] args) {
        // 有序列表！
        int[] nums = new int[]{1, 1, 1, 3, 5, 5};
        Solution1 solution = new Solution1();
        int size = solution.removeDuplicates(nums);
        System.out.println(size);
    }

}
