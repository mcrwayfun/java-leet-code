# [Longest Common Prefix][title]

## Description

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

**Example 1:**

```
Input: ["flower","flow","flight"]
Output: "fl"
```
**Example 2:**

```
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

**Tags:** String Array


## 解读题意
找出所有字符串中相同的字符串

## 思路1 
假设strs为目标数组

1. 以strs[0]作为标准，与strs之后的字符串作比较。比如`strs[0] = flower`，当`i = 1`，与**flow**比较，`length = Math.min(length, strs[i].length() = 4,`遍历`j = 0 -> 3`。当`i = 2`，与**flight**比较，`length = 4`,当`j = 2`，`o ！= i`，跳出循环，执行`strs[0].substring(0,length)`，返回结果`fl`

```java
class Solution { 
  
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)
            return "";

        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            length = Math.min(length, strs[i].length());
            for (int j = 0; j < length; j++) {
               if(strs[0].charAt(j) != strs[i].charAt(j)){
                   length = j;
                   break;
               }
            }
        }
        return strs[0].substring(0,length);
    }
}
```

[title]: https://leetcode.com/problems/longest-common-prefix/description/