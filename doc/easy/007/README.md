# [Reverse Integer][title]

## Description

Reverse Integer

**Example 1:**

```
Input: 123
Output: 321
```
**Example 2:**

```
Input: -123
Output: -321
```
**Example 3:**

```
Input: 120
Output: 21
```

**note**
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


**Tags:** String


## 解读题意
翻转一个int整数（带符号），注意溢出，如果有溢出，则返回0；

## 思路1 

- 利用`123%10=3;123/10=12;`可以循环获取每一位数，结束条件为`x!=0`;
- 用long来存储result，判断是否溢出（不可用int来存储result判断溢出）

```java
class Solution { 
  
     public int reverse(int x) {

        long result = 0;

        while(x != 0){
            result = result * 10 + x % 10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int)result;
    }
}
```
分析：
- Time complexity：O(n)

## 思路2

- 利用`123%10=3;123/10=12;`可以循环获取每一位数，结束条件为`x!=0`;
- 如果不允许使用long类型来存储，那么可以用newResult和result来比较判断，如果`(newResult) / 10 != result`为true，则说明溢出，因为溢出有损失。

```java
class Solution { 
  
     public int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int newResult = result * 10 + x % 10;
            // 溢出有损失，所以不等于原来的数
            if ((newResult) / 10 != result)
                return 0;

            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
```
分析：
- Time complexity：O(n)


[title]: https://leetcode.com/problems/reverse-integer/description/