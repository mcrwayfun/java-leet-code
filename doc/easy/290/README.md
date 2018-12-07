# [Word Pattern][title]

## Description

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

**Example 1:**

```
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
```
**Example 2:**

```
Input:pattern = "abba", str = "dog cat cat fish"
Output: false
```
**Example 3:**

```
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
```
**Example 4:**

```
Input: pattern = "abba", str = "dog dog dog dog"
Output: false
```

**Tags:** Hash Table


## 解读题意


## 思路1 

```java
class Solution { 
  
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;

        HashMap<Character, String> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            // 存在c但是c对应的value不相等
            if (map.containsKey(c) && !map.get(c).equals(words[i]))
                return false;
            else if (!map.containsKey(c) && map.containsValue(words[i]))
                return false;
            else {
                map.put(c, words[i]);
            }
        }

        return true;
    }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/word-pattern/