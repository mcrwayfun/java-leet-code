# [To Lower Case][title]

## Description

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

**Example 1:**

```
Input: "Hello"
Output: "hello"
```

Tags:** String

## 解读题意

## 思路1 

```java
class Solution {
   
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();

        int sub = 'a' - 'A';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] = (char) (chars[i] + sub);
        }

        return String.valueOf(chars);
    }
}
```

time complexity：O(n)


[title]: https://leetcode.com/problems/to-lower-case/