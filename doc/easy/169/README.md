# [Majority Element][title]

## Description

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Example 1:**

```
Input: [2,2,1,1,1,2,2]
Output: 2
```

**Tags:** Array


## 解读题意

## 思路1 

```java
class Solution { 
  
    public int majorityElement(int[] nums) {

        if (nums == null)
            throw new IllegalArgumentException();

        if (nums.length == 1 || nums.length == 2)
            return nums[0];

        // 遇到相同的值则count++,否则count--
        // 当count为0时重新获取major,并且count重新计算值
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }

        return major;
    }
}
```
分析：
- Time complexity：O(n)

[title]: https://leetcode.com/problems/majority-element/