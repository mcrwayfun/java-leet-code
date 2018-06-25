# [Valid Perfect Square][title]

## Description

Given a positive integer num, write a function which returns True if num is a perfect square else False.

**Note**
- Do not use any built-in library function such as sqrt


**Example 1:**

```
Input: 16
Returns: True
```
**Example 2:**

```
Input: 14
Returns: False
```


**Tags:** Binary Search

## 解读题意
判断给出的正数是否能开完全平方

## 思路1 
这个题可以转换为查找某一个数并判断其是否具有某种特性，查找就可以利用二分法来做。
1. 循环结点right可以只到`num/2`即可，不用到`num`。但可能会造成一种情况，当`num=1`,所以`right=0`，进不去循环条件。但`num=1`是正确的，所以优先排除`num=1`的情况。

```java
class Solution {
    
   public boolean isPerfectSquare(int num) {
        if (num <= 0)
            return false;

        if (num == 1)
            return true;

        int left = 1, right = num / 2;
        while (left <= right) {

            long mid = (right + left) >>> 1;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                left = (int) mid + 1;
            else
                right = (int) mid - 1;
        }

        return false;

    }
}
```
time complexity:O(logn)

[title]: https://leetcode.com/problems/valid-perfect-square/description/