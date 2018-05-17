# [Contains Duplicate][title]

## Description

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

**Example 1:**

```
Input: [1,2,3,1]
Output: true
```
**Example 2:**
```
Input: [1,2,3,4]
Output: false
```
**Example 3:**
```
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
```
**Tags:** Array


## 解读题意
给定一个数组，找出数组是否包含相同的元素，如果是则返回true，如果每个都不同，则返回false

## 思路1 
假设count为循环次数，nums为该数组
1. 先排序
2. 前后两个元素比较，如果相同的必定相邻
3. count < nums.length - 1，只有循环到倒数第二个数即可。

```java
class Solution { 
    public boolean containsDuplicate(int[] nums) {
        // 排序
        Arrays.sort(nums);
        // 比较，值相同必定相邻
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1])
                 return true; 
        }
        return false; 
    }
}
```

## 思路2
假设数组为nums
1. 利用HahSet特性判断

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
   
       Set<Integer> set = new HashSet<>(nums.length);
       // 利用set比较
       for(int x:nums){
          if(!set.add(x))
              return true;
       }
       return false; 
     }
}
```

[title]: https://leetcode.com/problems/contains-duplicate/description/