# [Find Smallest Letter Greater Than Target][title]

## Description

Given a list of sorted characters `letters` containing only lowercase letters, and given a target letter `target`, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is `target = 'z'` and letters = `['a', 'b']`, the answer is `'a'`.

**note**
1. letters has a length in range [2, 10000].
2. letters consists of lowercase letters, and contains at least 2 unique letters.
3. target is a lowercase letter.

**Example 1:**

```
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
```

**Tags:** Array HashTable


## 解读题意
给了一个有序的字母数组和一个target字母，求字母数组中第一个大于target的字母，数组是循环的，如果没有，那就返回第一个字母。

## 思路1 
1. 优先判断如果`target`大于`letters`数组的最后一个元素，则直接返回头元素
2. 循环`letters`数组中大于target的字母

```java
class Solution { 
  
     public char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length == 0)
            throw new IllegalArgumentException();

        // target 大于 letters最后一个元素，直接返回头元素
        int length = letters.length - 1;
        if (target >= letters[length])
            return letters[0];

        for (char ch : letters) {
            if(ch > target)
                return ch;
        }

        return letters[0];
    }

}
```
分析：
- Time complexity：O(n)

## 思路2
利用二分法来做
1. 优先判断如果`target`大于`letters`数组的最后一个元素，则直接返回头元素
2. 利用二分法找到令`letters[mid] > target`的数下标

```java
class Solution { 
    public char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length == 0)
            throw new IllegalArgumentException();

        // target 大于 letters最后一个元素，直接返回头元素
        int length = letters.length - 1;
        if (target >= letters[length])
            return letters[0];

        int left = 0, right = length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target)
                left = mid + 1;
            else right = mid;
        }

        return letters[right];
    }
}
```
分析：
- Time complexity：O(logn)

[title]: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/