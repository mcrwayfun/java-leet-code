# [Implement strStr()][title]

## Description

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Note**
What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

**Tags:** String Array

## 解读题意
给出两个字符串t和s，判断t是否包含s
## 思路1 
假设原串长度为n，匹配长度为m，思路就是对原字符串每一个长度为m的都判断是否跟匹配串一致，总共有n-m+1段。

```java
class Solution {
  public int strStr(String haystack, String needle) {

        int hayLength = haystack.length();
        int ndlLength = needle.length();

        if (ndlLength == 0)
            return 0;
        if (hayLength < ndlLength)
            return -1;

        for (int i = 0; i <= hayLength - ndlLength; i++) {
            for (int j = 0; ; j++) {
                if (j == ndlLength)
                    return i;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;

            }
        }

        return -1;
    }
}
```
分析：
- Time complexity：O(n)

[title]:https://leetcode.com/problems/first-unique-character-in-a-string/description/