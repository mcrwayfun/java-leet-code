# [Length of Last Word][title]

## Description

给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指由字母组成，但不包含任何空格的字符串。

**Example 1:**

```
Input: "Hello World"
Output: 5
```

**Tags:** String


## 解读题意


## 思路1 


```java
class Solution { 
  
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
```

[title]: https://leetcode-cn.com/problems/length-of-last-word/