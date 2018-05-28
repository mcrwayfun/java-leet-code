# [String to Integer][title]

## Description

Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

**Example 1:**

```
Input: "42"
Output: 42
```
**Example 2:**

```
Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
```
**Example 3:**

```
Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
```
**Example 4:**

```
Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.
```
**Example 5:**

```
Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
```
**note**
1. Only the space character ' ' is considered as whitespace character.
2. Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.


**Tags:** String Array


## 解读题意
获取字符串中的数字，需要符合以下要求。
这道题有点怪，不解释
- 空格为无效字符
- 首字符为字母，返回0
- 数字溢出，返回相应的INT_MAX或INT_MIN

## 思路1 

```java
class Solution { 
  public int myAtoi(String str) {

        int start = 0;
        int end = str.length();
        char[] chars = str.toCharArray();

        // 首字符为字母
        if ((chars[start] >= 'a' && chars[start] <= 'z') ||
                (chars[start] >= 'A' && chars[start] <= 'Z'))
            return 0;

        int result = 0;
        int sign = 1;
        while (start < end) {

            char num = chars[start];

            // 空字符串
            if (chars[start] == ' ')
                start++;
                // 字母
            else if ((chars[start] >= 'a' && chars[start] <= 'z') ||
                    (chars[start] >= 'A' && chars[start] <= 'Z'))
                start++;
                // 符号
            else if (chars[start] == '+' || chars[start] == '-') {
                sign = chars[start] == '+' ? 1 : -1;
                start++;
            }
            // 数字
            else if (chars[start] >= '0' && chars[start] <= '9') {
                int newResult = result * 10 + (num - '0');
                if ((newResult / 10) != result)
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result = newResult;
                start++;
            }

        }

        return result * sign;
    }
}
```
分析：
- Time complexity：O(n)


[title]: https://leetcode.com/problems/string-to-integer-atoi/description/