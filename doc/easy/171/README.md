# [Excel Sheet Column Number][title]

## Description

Given a column title as appear in an Excel sheet, return its corresponding column number.

**Example 1:**

```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
    
    Input: "A"
    Output: 1
    
    Input: "AB"
    Output: 28
    
    Input: "ZY"
    Output: 701
```

**Tags:** Math


## 解读题意

## 思路1 

```java
class Solution { 
  
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException();

        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result = result * 26 + (s.charAt(i) - 'A' + 1);

        return result;
    }
}
```
分析：
- Time complexity：O(n)

[title]: https://leetcode.com/problems/excel-sheet-column-number/