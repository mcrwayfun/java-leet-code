# [Merge Sorted Array][title]

## Description

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

**Note:**

- The number of elements initialized in nums1 and nums2 are m and n respectively.
- You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

**Example 1:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

**Tags:** Array


## 解读题意
给定两个有序整型数组nums1和nums2，将nums2插入到nums1中，混合后的数组需要排好序。

## 思路1 
因为两个数组是已经排好序了，所以直接进行比较即可。由于新的数组长度为m+n，所以可以从后向前赋值。因为num1和nums2是排好序的，所以先比较nums1和nums2最后两个元素，比较大的就插入到m+n-1的位置。需要考虑的情况下，当nums1循环结束了，nums2还有剩余元素。所以还需要一个循环将nums2中剩余元素插入到nums1中。 定义三个指针`i=m-1`，`j=n-1`，`k=m+n-1`
1. 比较nums1[i]和nums2[j]的值，若nums1[i]数值大则插入到k的位置，并且`i--，k--`，反之nums2[j]值插入到k的位置，并且`j--,k--`
2. 循环执行步骤1直接`i<0`或者`j<0`
3. 若`j>=0`,说明nums2数组中还有元素未插入到nums1，用循环将nums2剩余元素插入到剩下的的位置即可。


```java
class Solution { 
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1.length < m + n || nums1.length == 0)
            return;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];

    }
}
```
- **time complexity:O(n)**

[title]: https://leetcode.com/problems/merge-sorted-array/description/