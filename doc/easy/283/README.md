# [Move Zeroes][title]

## Description

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

**Example 1:**

```
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```
**note**
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.


**Tags:** Array


## 解读题意
将数组中的0元素移到数组末，并且不改变非零元素的相对位置

## 思路1 
假设nums为该数组，
0 1 0 3 12 position = 0
第一次循环：0 1 0 3 12 x = 0,position = 0
第二次循环：1 1 0 3 12 x = 1,position = 1
第三次循环：1 1 0 3 12 x = 0,position = 1
第四次循环：1 3 0 3 12 x = 3,position = 2
第五次循环：1 3 12 3 12 x = 12,position = 3

1. 遍历数组，若发现不为0的数，则向前移动至position位置（初始为0），然后position++
2. 遍历结束，所有非0数已经移动到数组前方
3. 将数组剩余部分填充为0

```java
class Solution { 
  
    public void moveZeroes(int[] nums) {

        int position = 0;
        for (int x : nums)
            if (x != 0) nums[position++] = x;

        while (position < nums.length)
            nums[position++] = 0;
    }
}
```


[title]: https://leetcode.com/problems/move-zeroes/description/