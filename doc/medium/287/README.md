# [Find the Duplicate Number][title]

## Description

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

**Example 1:**

```
Input: [1,3,4,2,2]
Output: 2
```
**note**
1. You must not modify the array (assume the array is read only).
2. You must use only constant, O(1) extra space.
3. Your runtime complexity should be less than O(n2).
4. There is only one duplicate number in the array, but it could be repeated more than once.


**Tags:** Array


## 解读题意

## 思路1 
利用二分法

```java
class Solution { 
  
    public int findDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;

        int left = 1, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countRange(nums, left, mid);
            if (left == right) {
                // 存在重复数字
                if (count > 1)
                    return left;

                break;
            } else {
                // 重复数字出现在左闭区间
                if (count > (mid - left) + 1)
                    right = mid;
                else
                    left = mid + 1;
            }
        }

        return -1;
    }

    private int countRange(int[] nums, int start, int right) {

        int count = 0;
        for (int x : nums) {
            if (x >= start && x <= right)
                count++;
        }

        return count;
    }
}
```

## 思路2
使用快慢指针，但是需要注意的是
1. 因为数组范围为[1,n]，所以索引0处无指向，可以使用该方法
2. 必须存在重复数字
3. 设置快慢指针，两者以不同速度移动，相遇时，必定在环上
4. 重新设置一个指针，走相同步数直到相遇，相遇点为入环点

```java
public class Solution {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        // 使用快慢指针前提是一定存在重复数且数字0不在范围内
        int slow = 0;
        int fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int p = 0;
        int entrance = nums[fast];
        // 重设指针，走相同步数直至相遇，则相遇点为入环点
        while (p != entrance) {
            p = nums[p];
            entrance = nums[entrance];
        }

        return p;
    }
}
```

[title]: https://leetcode.com/problems/find-the-duplicate-number/