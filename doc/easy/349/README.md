# [Intersection of Two Arrays][title]

## Description

Given two arrays, write a function to compute their intersection.

**Note**
- Each element in the result must be unique.
- The result can be in any order.

**Example 1:**

```
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
```

**Tags:** Hash Table、Binary Search
## 解读题意
给出两个数组，找出它们的交集。结果不能重复；结果无序排序

## 思路1 
1. 先对两个数组进行排序
2. 定义两个指针i和j，分别来控制nums1和nums2。比较`nums[i]`和`nums[j]`，若`nums[i] > nums[j]`则**`j+1`**,若`nums[i] < nums[j]`则**i+1**,否则将`nums[i]`添加到结果集中，并且i和j均+1

```java
class Solution {
    
   public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int x : set) {
            result[index++] = x;
        }

        return result;
    }
}
```
time complexity:O(n)

## 思路2
1. 对`nums2`排序，对`nums1`进行循环操作
2. 对`nums1`中的每个元素都去`nums2`中去搜索（二分查找）一次，查看有没有相同元素，若有则加入结果集中

```java
class Solution {
    
  public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null ||
                nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums2);

        HashSet<Integer> intersectSet = new HashSet<>();


        int index = 0;
        while (index < nums1.length) {

            if (binarySearch(nums2, nums1[index]))
                intersectSet.add(nums1[index]);

            index++;
        }

        int[] result = new int[intersectSet.size()];

        index = 0;
        for (int x : intersectSet) {
            result[index++] = x;
        }

        return result;
    }

    private boolean binarySearch(int[] nums2, int target) {

        int left = 0, right = nums2.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (nums2[mid] < target)
                left = mid + 1;
            else if (nums2[mid] > target)
                right = mid - 1;
            else
                return true;
        }

        return false;
    }
}
```
complexity:O(nlogn)

[title]: https://leetcode.com/problems/intersection-of-two-arrays/description/