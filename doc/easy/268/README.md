# [Missing Number][title]

## Description

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

**Example 1:**

```
Input: [3,0,1]
Output: 2
```

**Example 2:**

```
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
```

**Tags:** Math


## 解读题意


## 思路1 
找缺失，找N个相同值中不同的那个数，这类题可以使用异或^

```java
class Solution { 
  
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException();

        // 使用异或操作，a^b^b=a
        // 这意味着两个数值相同的异或可消除并显示原来的数字
        int xor = 0, i = 0;
        for (; i < nums.length; i++)
            // 使用下标和对应的值进行异或
            xor = xor ^ i ^ nums[i];

        // 与n进行异或
        return xor ^ i;
    }
}
```
- Time complexity：O(n)

[title]: https://leetcode.com/problems/missing-number/