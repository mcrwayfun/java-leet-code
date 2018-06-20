# [Intersection of Two Arrays II][title]

## Description

Given two arrays, write a function to compute their intersection.

**Note**
- Each element in the result should appear as many times as it shows in both arrays.
- The result can be in any order.

**Example 1:**

```
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
```

**Tags:** Array、Sort 

## 解读题意
给出两个数组，找出它们的交集。结果允许重复；结果无序排序

## 思路1 
1. 先对两个数组进行排序
2. 定义两个指针i和j，分别来控制nums1和nums2。比较`nums[i]`和`nums[j]`，若`nums[i] > nums[j]`则**`j+1`**,若`nums[i] < nums[j]`则**i+1**,否则将`nums[i]`添加到结果集中，并且i和j均+1

```java
class Solution {
    
   public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[list.size()];
        int index = 0;
        for (int x : list) {
            result[index++] = x;
        }

        return result;
   }
}
```
time complexity:O(n)

[title]: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/