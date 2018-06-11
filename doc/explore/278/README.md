# [First Bad Version][title]

## Description

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

**Example 1:**

```
Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
```


**Tags:** Array


## 解读题意
有一系列版本，如果有一个版本是坏的，则后面跟着的全是坏的，给了一个API函数可以用来判定当前版本是否是坏的，尽可能少的调用这个API，找出第一个坏版本

## 思路1 
减少调用API次数可以转换为减少循环次数，使用二分查找法即可。若`mid`是坏的，则坏的边界在左边，`right = mid -1`；若`mid`是好的，则坏的边界在右边，`left = mid + 1`，循环直到 `left <= right`

有点需要注意，当n足够大，`left + right`可能会造成溢出，所以使用`left + (right - left) / 2`来避免溢出

```java
class Solution { 
  
 	public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {
			
			/** mid = (left + right ) /2 */
            int mid = left + (right - left) / 2;
			
            if (isBadVersion(mid))
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;

    }

}
```
- Time complexity：O(logn)



[title]: https://leetcode.com/problems/first-bad-version/description/