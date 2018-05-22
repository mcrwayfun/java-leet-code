# [Reverse String][title]

## Description

Write a function that takes a string as input and returns the string reversed.

**Example 1:**

```
Given s = "hello", return "olleh".
```

**Tags:** string

## 解读题意
将字符串反转
## 思路1 
   
```java
class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
```
分析：
- Time complexity：O(n^2)


[title]:https://leetcode.com/problems/reverse-string/description/