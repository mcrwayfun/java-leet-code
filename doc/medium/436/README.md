# [Find Right Interval][title]

## Description

Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

**Note：**

- You may assume the interval's end point is always bigger than its start point.
- You may assume none of these intervals have the same start point.

**Example 1:**

```
Input: [ [1,2] ]

Output: [-1]

Explanation: There is only one interval in the collection, so it outputs -1.
```

**Example 2:**

```
Input: [ [3,4], [2,3], [1,2] ]

Output: [-1, 0, 1]

Explanation: There is no satisfied "right" interval for [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point;
For [1,2], the interval [2,3] has minimum-"right" start point.
```

**Example 3:**

```
Input: [ [1,4], [2,3], [3,4] ]

Output: [-1, 2, -1]

Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
For [2,3], the interval [3,4] has minimum-"right" start point.
```

**Tags:** Hash Table

## 解读题意
给出一组区间（无序），现在要在这组区间里，找到每个区间的右区间（可能有多个），能够满足右区间的start要大于等于当前区间的end。找到右区间中start值最小的，并返回其在数组中的下标。

## 思路1 

用一个数据结构来存储区间start与下标之间的映射关系，TreeMap本身有排序的性质（logn），现有它来存储映射关系。ps：用到了TreeMap的一个api，**ceilingEntry：smallest entry whose key > given key**
1. 将`intervals[i].start`作为key，下标i为value存入TreeMap中，为区间的start和数组下标建立映射关系。
2. 遍历区间数组`intervals[]`，用当前的`intervals[i].end`,通过`ceilingEntry`方法，找到在TreeMap中，比`intervals[i].end`大且在TreeMap中最小的。若存在，则返回当前`entry`的value，即下标；若不存在，则返回-1


```java
public class Solution {

     public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }

        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}
```
time complexity:O(nlogn)。


[title]: https://leetcode.com/problems/find-right-interval/description/