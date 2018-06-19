# [Peak Index in a Mountain Array][title]

## Description

Let's call an array A a mountain if the following properties hold:

- A.length >= 3
- There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

**Example 1:**

```
Input: [0,1,0]
Output: 1
```

**Example 2:**

```
Input: [0,2,1,0]
Output: 1
```

**Tags:** Binary Search

## 解读题意
有这么一个数组，数值会随着下标一直增加，直到顶峰，到顶峰后数值随着下标增加而减少。找出数组中的顶峰（即找数组中的最大值），并返回其下标

## 思路1 
定义指针`index`，当数组数值不再增加时指针会停止，返回指针数值。

```java
class Solution {
    
   public int peakIndexInMountainArray(int[] A) {

        if (A == null || A.length == 0)
            return 0;

        int index = 0;

        while (A[index] < A[index + 1])
            index++;

        return index;
    }

}
```
time complexity:O(n)

## 思路2
利用二叉搜索树来解决问题。该题的数组`A[]`本身是无序的，但是我们不用返回数组的数值，可以将数组看作A`[true,true,true,...,true,false]`，判断`A[i] < A[i+1]`即可。

```java
public class Solution1 {

     public int peakIndexInMountainArray(int[] A) {

        if (A == null || A.length == 0)
            return 0;

        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

}
```
time complexity:O(logn)

[title]: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/