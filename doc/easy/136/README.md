# [Single Number][title]

## Description

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**

```
Input: [2,2,1]
Output: 1
```
**Example 2:**
```
Input: [4,1,2,1,2]
Output: 4
```

**Tags:** Array


## 解读题意
给定一个不为空的整数数组，除了一个值，每个元素都出现两个，找出那个仅出现一次的。

## 思路1 
假设nums为该数组
1. 使用异或来运算，数与自己异或，返回0；数与0异或，返回自己。

```java
class Solution {

       public int singleNumber(int[] nums) {

        int length = nums.length;

        if (length % 2 == 0)
            return 0;

        if (length == 1) {
            return nums[0];
        }

        int temp = 0;
        // 利用异或运算
        // 数与自己异或，返回0
        // 与0异或，返回自己
        for (int i = 0; i < length; i++) {
            temp = temp ^ nums[i];
        }

        return temp;
    }
}
```

## 思路2
假设数组为nums
1. 利用HahSet特性判断
2. sum(set)-sum(nums)得到的就是仅出现一次的数，缺点就是相加可能超出Integer.MAX_VALUE，造成溢出

```java
class Solution {
   
     public int singleNumber(int[] nums) {

        int length = nums.length;

        if (length % 2 == 0)
            return 0;

        if (length == 1) {
            return nums[0];
        }

        int numSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
            numSum += x;
        }

        int sum = 0;
        for (int x : set) {
            sum += x;
        }

        // sum(set)-sum(nums)得到的就是仅出现一次的数
        return 2 * sum - numSum;

    }
}
```

[title]: https://leetcode.com/problems/single-number/description/