# [Find Peak Element][title]

## Description

A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

**Example 1:**

```
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
```

**Example 2:**

```
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
```

**Tags:** Binary Search

## 解读题意
给定一个数组，可能会存在多个顶峰，即`nums[i] > nums[i+1]`，找出其中一个顶峰即可，并返回顶峰的下标

## 思路1
利用二叉搜索树来解决问题。该题的数组`nums[]`本身是无序的，但是我们不用返回数组的数值，可以将数组看作nums`[true,false,true,...,true,false]`，判断`nums[i] < nums[i+1]`即可。

```java
public class Solution1 {

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

}
```
time complexity:O(logn)


[title]: https://leetcode.com/problems/find-peak-element/description/