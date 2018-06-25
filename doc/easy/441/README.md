# [Guess Number Higher or Lower][title]

## Description

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

```
-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
```

**Example 1:**

```
n = 10, I pick 6.

Return 6.
```


**Tags:** Binary Search

## 解读题意
猜数字，给出一个数字，通过调用api`guess(int num)`，若猜低了则返回**-1**，猜高了返回**1**，猜中了返回**1**

## 思路1 
这个题可以转换为查找某一个数并判断其是否具有某种特性，查找就可以利用二分法来做。

```java
class Solution {
    
    public int guessNumber(int n) {

        if (n < 0)
            throw new IllegalArgumentException();

        int left = 1, right = n;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
}
```
time complexity:O(logn)

[title]: https://leetcode.com/problems/guess-number-higher-or-lower/description/