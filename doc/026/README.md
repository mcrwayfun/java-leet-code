# [Remove Duplicates from Sorted Array][title]

## Description

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

**Example 1:**

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```
**Example 2:**
```
Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
```
**Tags:** Array

## 解读题意
因为array是有序的，如果存在相同的元素，那么必定是相邻的。

## 思路1 

第一反应，在java中，可以用set来处理。因为set不会存储重复的元素。但是，居然错了。刚开始百思不得其解，后来debug标准答案，发现nums数组改变了。因为是引用，所以改变不奇怪，莫名其妙的是题目明明已经说了不用在乎nums数组，只管输出的length正确与否。综上，是道奇怪的题。

```java
class Solution {
     public int removeDuplicates(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
       
        return set.size();
    }
}
```

## 思路2 

因为array是有序的，如果存在相同的元素，那么必定是相邻的。所以只用维护两个指针i，j。i保留当前有效长度，j用来循环，遇到重复元素跳过，i不记录；元素不同则i++，并且num[i]设置为nums[j]。

```java
class Solution {
   public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
   }
}
```

[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/