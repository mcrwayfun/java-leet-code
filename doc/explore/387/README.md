# [First Unique Character in a String][title]

## Description

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Example 1:**

```
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
```
**Note**
You may assume the string contain only lowercase letters.

**Tags:** String HashTable

## 解读题意
给定一个字符串，找出字符串中第一个不重复的字符，并返回它在字符串中的下标
## 思路1 
1. 定义一个map，用来存储字符串中的每个字符。key存储字符，value存储字符出现次数
2. 遍历map找出第一个出现且value=1的key，返回其index

使用了` map.getOrDefault`，它会执行以下代码，所以影响了效率。
```java
return (((v = get(key)) != null) || containsKey(key))
            ? v
            : defaultValue;
```


```java
class Solution {
   public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();
        // 放入map中，若已经存在，则value++，否则value=1
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 遍历找出第一个value=1的key的index
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}
```
分析：
- Time complexity：O(n)

## 思路2
1. 定义一个长度为26的数组，用来存储26个字母出现的次数（题目指明只存在小写字母）
2. 遍历数组找出第一个出现且value=1的key，返回其index

相比于第一种方法，效率更高。
```java
class Solution {
   public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
```
分析：
- Time complexity：O(n)


[title]:https://leetcode.com/problems/first-unique-character-in-a-string/description/