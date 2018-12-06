# [Plus One][title]

## Description

Given a **non-empty** array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

**Example 1:**

```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```
**Example 2:**
```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```

**Tags:** Array


## 解读题意
给定一个非空数组表示一个正整数，为这个整数+1，并输出结果，类型为数组。注意：数组已经排过序（逆序），最高位在数组的头部。

## 思路1 
假设count为循环次数，nums为该数组
1. 判断当前要+1的数是否为9，不是9则直接+1并返回数组；反之，若刚好是9，则当前项置0，执行循环
2. 若当前数组的值全部为9，则拓展一个新数组并将首位置1，返回新数组。 

```java
class Solution { 
   public int[] plusOne(int[] digits) {

        int count = digits.length;
        for (int i = count - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newInt = new int[count + 1];
        newInt[0] = 1;
        return newInt;
    }
}
```


[title]: https://leetcode.com/problems/plus-one/description/