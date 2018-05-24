# [Valid Palindrome][title]

## Description

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

**Note:**

For the purpose of this problem, we define empty string as valid palindrome.

**Example 1:**

```
Input: "A man, a plan, a canal: Panama"
Output: true
```
**Example 2:**
```
Input: "race a car"
Output: false
```

**Tags:** String Array


## 解读题意
判断一个字符串是不是回文字符串，忽略除了字母和数字以外的字符。

## 思路1 
1. 定义两个指针用于控制循环，分别是`start = 0`和`end = s.length() - 1`，循环结束条件为`start >= end`
2. 进入循环：从字符串左边，即`start = 0`开始，判断当前字符是否为字母或者数字，不是则继续执行步骤2；是则`start++`，且执行3
3. 从字符串右边，即`end = s.length() - 1`开始，判断当前字符是否为字母或者数字，不是则继续执行步骤2；是则`end--`，且执行4
4. 判断当前`chars[start]`和`chars[end]`是否相等，是则执行步骤2；不是则结束
```java
class Solution {

        public boolean isPalindrome(String s) {
       
               int start = 0;
               int end = s.length() - 1;
               char[] chars = s.toCharArray();
               while (start < end) {
                   // 不是字母或者数字
                   if (start < s.length() && !valid(chars[start]))
                       start++;
                   else if (end >= 0 && !valid(chars[end]))
                       end--;
                   else {
                       if (Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end]))
                           return false;
       
                       start++;
                       end--;
                   }
       
               }
               return true;
           }
       
           private Boolean valid(char c) {
               return ((c >= 'a' && c <= 'z') ||
                       (c >= 'A' && c <= 'Z') ||
                       (c >= '0' && c <= '9'));
           }
}
```
分析：
- Time complexity：O(n)

## 思路2
1. 用正则表达式，替换字符串s中除了大小写字母，数字以外的字符。`[A-Za-z0-9]`:匹配大小写字母，数字的字符簇；当在方括号`[]`里使用`"^"`，表示非或排除的意思
2. 将字符串反转后与原字符串进行比较

```java
class Solution {
   
   public boolean isPalindrome(String s) {
           String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
           String rev = new StringBuffer(actual).reverse().toString();
           return actual.equals(rev);
       }
}
```

[title]: https://leetcode.com/problems/single-number/description/