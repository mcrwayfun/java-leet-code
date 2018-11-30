# [Sort-array-by-parity][title]

## Description

给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

**Example 1:**

```
输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
```

**Tags:** Array

## 解读题意

## 思路1 
定义一个指针记录数组中第一个奇数的位置，用于交换

```java
class Solution {
    
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException();

        int[] ret = new int[A.length];
        // 记录数组中第一个奇数的位置
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                int temp = A[i];
                A[i] = A[index];
                A[index++] = temp;
            }

        }
        return ret;
    }

}
```
time complexity:O(n)

[title]: https://leetcode-cn.com/problems/sort-array-by-parity/