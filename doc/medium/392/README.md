# [Is Subsequence][title]

## Description

Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

**Example 1:**

```
s = "abc", t = "ahbgdc"

Return true.
```

**Example 2:**

```
s = "axc", t = "ahbgdc"

Return false.
```

**Tags:** Two pointer

## 解读题意
有两个字符串s和t，判断s是否为t的子序列（注意s的原有顺序不能更改）

## 思路1 
1. 定义两个指针i和j，申明`char[] charS = s.toCharArray()`和`char[] charT = t.toCharArray()`
2. 遍历`chatT`，当`charS[i] == charT[j]`命中时，指针i和j分别加1，变量count加1；否则j加1
3. 循环结束，返回`count == s.length()`

```java
class Solution {
    public boolean isSubsequence(String s, String t) {

        if (s == null || t == null || s.length() > t.length())
            return false;

        int i = 0, j = 0;
        int count = 0;
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        while (j < charT.length && i < charS.length) {
            // 命中
            if (charS[i] == charT[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count == s.length();
    }
}
```

- time complexity:O(n)。


[title]: https://leetcode.com/problems/is-subsequence/description/