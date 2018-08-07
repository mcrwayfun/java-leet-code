# [Backspace String Compare][title]

## Description

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

**Example 1:**

```
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
```
**Example 2:**

```
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
```
**Example 3:**

```
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
```
**Example 4:**

```
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
```

**Tags:** Stack Two Pointer

## 解读题意
有两个字符串S和T，当遇到#号时就删除前面一个有效字符，判断经过处理后的S和T是否相等

## 思路1 
题目中要求： O(N) time and O(1) space，那么便不能使用栈来解决了。所以用遍历的方式，遇到#号则回退，最后比较两个字符是否相等即可。

```java
class Solution {
    
    public boolean backspaceCompare(String S, String T) {


        if (S == null || T == null ||
                S.length() == 0 || T.length() == 0) {
            return false;
        }

        return buildString(S).equals(buildString(T));
    }

    private String buildString(String str) {

        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


}
```

- time complexity:O(n+m)

[title]: https://leetcode.com/problems/backspace-string-compare/description/