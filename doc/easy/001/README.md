# [Two Sum][title]

## Description

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

**Example 1:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```
**note**
1. You must do this in-place without making a copy of the array.
2. Minimize the total number of operations.


**Tags:** Array，HashTable


## 解读题意
给定一个数组，数组中某两个数加起来等于指定数，求这两个数的下标。

## 思路1 
假设nums为该数组，target为指定数

1. 遍历循环每个元素x，找出是否有能够满足target-x的另一个值


```java
class Solution { 
  
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
```
分析：
- Time complexity：O(n^2)，外层循环n次，内层循环n-1次，所以时间复杂度为O(n^2)
- Space complexity：O(1)，空间负责度为常数

## 思路2
思路1用了最暴力循环的方式，两次循环找出了答案，时间复杂度为O(n^2)，但是有更好的方法来解决：使用HashMap作为存储。`key`为当前值，value为索引。此时要先判断`target - nums[i] = 9 - 2 = 7`是否存在于map中，若不存在，则插入键值`key = 2,value = 0`；之后`i = 1，num[1] = 7`，此时`9 - 7 = 2`,`nums[0] = 2`已经存在于map中，那么`value = 0 = map.get(2)`取出值作为第一个返回值，当前`i`作为第二个返回值。

```java
class Solution { 
   public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sub = target - nums[i];
            if(map.containsKey(sub))
                return new int[]{map.get(sub),i};
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
```
分析：
- Time complexity：O(n)
- Space complexity：O(n)


[title]: https://leetcode.com/problems/two-sum/description/