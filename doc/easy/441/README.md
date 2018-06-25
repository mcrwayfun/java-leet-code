# [Arranging Coins][title]

## Description

You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.


**Example 1:**

```
n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
```

**Example 1:**

```
n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
```


**Tags:** Math

## 解读题意
有这样一种形状，满足第i层有i个。现在给一个数字n，让其组成这样一个形状，若某层不能满足规则，比如当`n=5`，第1层1个，第2层2个，第3层应该有3个，但此时只剩下2个，所以只能返回2

## 思路1 
这道题是一道数学题，找到规律 `n=(1+x)*x/2`，即可求出`x = (-1 + sqrt(8 * n + 1)) / 2`

```java
class Solution {
    
  public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
  }
}
```
time complexity:O(1)，这个解法无n无关

[title]: https://leetcode.com/problems/arranging-coins/description/