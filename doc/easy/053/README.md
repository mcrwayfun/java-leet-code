# [Maximum Subarray][title]

## Description

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example 1:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Tags:** Array

## 解读题意

## 思路1 

```java
class Solution {
    
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0)
            return max;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果加上前一个数sum变为负数，则sum重新取当前值计算
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];

            if (sum > max)
                max = sum;
        }

        return max;
    }
}
```
分析：
- Time complexity：O(n)


[title]: https://leetcode.com/problems/maximum-subarray/