# [Sqrt(x)][title]

## Description

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```
**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```


**Tags:** Binary Search


## 解读题意
求一个数的开根号，如果开根号数不为整数，则返回其整数部分

## 思路1 
使用二分法来解决问题，注意两点
1. 注意`mid*mid`可能会造成溢出，故使用long来存储
2. 当`mid*mid < x`，会存在一种情况。比如当x=8，此时mid=2，`2*2<8`会进入此分支。根据题目要求答案为浮点数时只取整，mid=2是正确答案，所以加多一个条件判断，当`(mid + 1) * (mid + 1) > x`时，返回mid=2

```java
class Solution { 
  
 	 public int mySqrt(int x) {

        if (x == 0)
            return 0;

        if (x == 1)
            return 1;

        int left = 1, right = x / 2;
        while (left <= right) {

            long mid = (left + right) >>> 1;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid > x)
                right = (int) mid - 1;
            else {
                if ((mid + 1) * (mid + 1) > x)
                    return (int) mid;
                else
                    left = (int) mid + 1;
            }
        }

        return left;
    }

}
```
分析：
- Time complexity：O(logn)

[title]: https://leetcode.com/problems/sqrtx/description/