# [Valid Anagram][title]

## Description

Given two strings s and t , write a function to determine if t is an anagram(相同字母异序词) of s.

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

**note**
You may assume the string contains only lowercase alphabets.


**Tags:** String Array


## 解读题意
判断字符串t是不是s的相同字母异序词：由此可以得出s和t长度相同

## 思路1 
1：将s和t转换成数组并排序，利用`Arrays.equals`判断相等则说明符合题意。

```java
class Solution { 
  
   public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1,chars2);
    }

}
```
- Time complexity：O(nlogn)：`Arrays.sort`采用的是快排，复杂度为O(nlogn)，`Arrays.equals`复杂度为O(n)，综上，复杂度为`O(nlogn)`

## 思路2 
1：维护一个长度为26的数组letters，控制字符s和t在数组中count。s字符串用于增加count，而t字符串用于减少count
2：遍历letters，判断变量x是否为0

```java
class Solution { 
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)-'a']++;
            letters[t.charAt(i)-'a']--;
        }

        for(int x:letters){
            if (x != 0)
                return false;
        }

        return true;
    }

}
```
- Time complexity：O(n)


[title]: https://leetcode.com/problems/valid-anagram/description/