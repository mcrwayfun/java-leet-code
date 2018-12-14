# [Sum of Two Integers][title]

## Description

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.


**Example 1:**

```
Input: a = 1, b = 2
Output: 3
```

**Tags:** Bit Manipulation

## 解读题意

## 思路1 

```java
class Solution {
    
    public int getSum(int a, int b) {
        if (b == 0)
            return a;

        while (b != 0) {
            int sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }

        return a;
    }
}
```
time complexity:

[title]: https://leetcode.com/problems/sum-of-two-integers/