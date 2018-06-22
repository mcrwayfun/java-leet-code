# [Search Insert Position][title]

## Description

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**

```
Input: [1,3,5,6], 5
Output: 2
```
**Example 2:**

```
Input: [1,3,5,6], 2
Output: 1
```
**Example 3:**

```
Input: [1,3,5,6], 7
Output: 4
```
**Example 4:**

```
Input: [1,3,5,6], 0
Output: 0
```

**Tags:** Array HashTable


## 解读题意
给出一个已经排序的数组和一个目标数target，判断这个目标数在数组中是否存在，若存在则返回相应下标，若不存在，则返回它应该插入位置的下标。

## 思路1 
使用二分法来解决问题，可以优先处理target大于数组最大数，直接返回数组长度+1；target小于数组最小数，直接返回0

```java
class Solution { 
  
 	public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        int length = nums.length - 1;

        // add to end
        if (target > nums[length])
            return length + 1;

        // add to head
        if (target < nums[0])
            return 0;

        int left = 0, right = length;
        while (left <= right) {

            int mid = left + (right - left) >>> 1;
            int temp = nums[mid];

            if (temp == target)
                return mid;
            else if (temp < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

}
```
分析：
- Time complexity：O(logn)

[title]: https://leetcode.com/problems/search-insert-position/description/