package com.qingtian.medium._287;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/12/17
 */
public class Solution1 {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        // 使用快慢指针前提是一定存在重复数且数字0不在范围内
        int slow = 0;
        int fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int p = 0;
        int entrance = nums[fast];
        // 重设指针，走相同步数直至相遇，则相遇点为入环点
        while (p != entrance) {
            p = nums[p];
            entrance = nums[entrance];
        }

        return p;
    }

    public static void main(String[] args) {
        int duplicate = new Solution1().findDuplicate(new int[]{1, 2, 3, 4, 2});
        System.out.println(duplicate);
    }
}
