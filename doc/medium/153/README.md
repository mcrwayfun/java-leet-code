# [Find Minimum in Rotated Sorted Array][title]

## Description

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

**Example 1:**

```
Input: [3,4,5,1,2] 
Output: 1
```

**Example 2:**

```
Input: [3,4,5,1,2] 
Output: 1
```

**Tags:** Binary Search

## 解读题意
有一个升序排列的数组，可能会经过旋转，求其中最小的元素。

## 思路1 
利用二分法来解决
1. `int left = 0, right = nums.length - 1;`
2. 如果`nums[left] < nums[right]`，则表明没有发生旋转，直接返回`nums[0]`
3. 对nums进行二分法，如果`nums[left] < nums[mid]`，是升序的，则说明最小数在右半部分，`left = mid`；否则说明最小数在左半部分，`right = mid`
4. 循环直到left和right指针相邻，返回它们中比较小的那个数

```java
public class Solution {

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[0];
        }

        // 进行了旋转
        while (right - left > 1) {
            int mid = (right + left) / 2;
            if (nums[left] < nums[mid])
                left = mid;
            else right = mid;
        }

        return Math.min(nums[left], nums[right]);
    }
}
```
time complexity:O(logn)。


[title]: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/