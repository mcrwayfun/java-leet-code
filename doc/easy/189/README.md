# [Rotate Array][title]

## Description

Given an array, rotate the array to the right by k steps, where k is non-negative.

**Example 1:**

```
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
```
**Example 2:**
```
Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
```
**Tags:** Array

**Note：**
- Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
- Could you do it in-place with O(1) extra space?

## 解读题意
给定一个数组，一个k，求数组向右前进k后（超过数组长度，末项变为首项），数组变成了什么？

## 思路1 
这是一个数组反转的问题。假设k=3，有一个[1,2,3,4,5,6,7]数组，那么可以这么求解：
1. 7 6 5 4 3 2 1（反转全部数）
2. 5 6 7 4 3 2 1（反转前k个数）
3. 5 6 7 1 2 3 4（反转n-k个数）



```java
class Solution {
     public void rotate(int[] nums, int k) {
        k %= nums.length;
        // 数组顺序全部反过来
        reverse(nums, 0, nums.length - 1);
        // 反转前k个
        reverse(nums, 0, k - 1);
        // 反转n-k个
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {

        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

[title]: https://leetcode.com/problems/rotate-array/description/