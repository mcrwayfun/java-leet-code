# [Two Sum II - Input array is sorted][title]

## Description

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**note**
1. Your returned answers (both index1 and index2) are not zero-based.
2. You may assume that each input would have exactly one solution and you may not use the same element twice.

**Example 1:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

**Tags:** Array，HashTable


## 解读题意
给定一个数组，数组中某两个数加起来等于指定数，求这两个数的下标（从1开始）。

## 思路1 
假设nums为该数组，target为指定数

1. 使用HashMap作为存储。`key`为当前值，value为索引。此时要先判断`target - nums[i] = 9 - 2 = 7`是否存在于map中，若不存在，则插入键值`key = 2,value = 0`；之后`i = 1，num[1] = 7`，此时`9 - 7 = 2`,`nums[0] = 2`已经存在于map中，那么`value = 0 = map.get(2) + 1`取出值作为第一个返回值，当前`i + 1`作为第二个返回值。

```java
class Solution { 
  
     public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2)
            return new int[]{};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {

            int value = target - numbers[i];
            if (!map.containsKey(value)) {
                map.put(numbers[i], i);
            } else {
                return new int[]{map.get(value) + 1, i + 1};
            }

        }

        return new int[]{};
    }

}
```
分析：
- Time complexity：O(n)

## 思路2
1. 利用两个指针left和right，分别从数组的头和尾向中间移动，若`target == numbers[left] + numbers[right]`是否为真，若是则直接返回`new int[]{left + 1, right + 1}`；若`numbers[left] + numbers[right] < target`，则left指针加1，往右移；否则right指针减1，往左移；
2. 循环直到left和right指针重合


```java
class Solution { 
    public int[] twoSum(int[] numbers, int target) {

        if (numbers == null || numbers.length < 2)
            return new int[]{};

        int left = 0, right = numbers.length - 1;
        while (left < right) {

            int value = numbers[left] + numbers[right];
            if (value == target) {
                return new int[]{left + 1, right + 1};
            } else if (value < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }
}
```
分析：
- Time complexity：O(n)

[title]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/