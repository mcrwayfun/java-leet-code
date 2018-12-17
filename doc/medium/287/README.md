# [Find the Duplicate Number][title]

## Description

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

**Example 1:**

```
Input: [1,3,4,2,2]
Output: 2
```
**note**
1. You must not modify the array (assume the array is read only).
2. You must use only constant, O(1) extra space.
3. Your runtime complexity should be less than O(n2).
4. There is only one duplicate number in the array, but it could be repeated more than once.


**Tags:** Array


## 解读题意

## 思路1 
利用二分法

```java
class Solution { 
  
    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;

        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countRange(nums, left, mid);
            if (left == right) {
                // 存在重复数字
                if (count > 1)
                    return left;

                break;
            } else {
                // 重复数字出现在左闭区间
                if (count > (mid - left) + 1)
                    right = mid;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }

    private int countRange(int[] nums, int start, int right) {

        int count = 0;
        for (int x : nums) {
            if (x >= start && x <= right)
                count++;
        }

        return count;
    }
}
```


[title]: https://leetcode.com/problems/find-the-duplicate-number/