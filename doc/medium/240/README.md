# [Search a 2D Matrix II][title]

## Description

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

**Note:**

- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

**Example 1:**

```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
```

**Tags:** 

## 解读题意
给出一个排过序的二维数组（从左到右，从上到下升序），判断target是否在数组中，若有则返回true，反之则是false

## 思路1 
因为已经是按规则排好序的，所以能够在二维数组中找到两个点（右上角和左下角），使得行和列一增一减，从而遍历整个二维数组。所以算法的复杂度应该为O（m+n）

```java
public class Solution {

      public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int column = matrix[0].length - 1;
        while (row <= matrix.length - 1 && column >= 0) {

            if (target == matrix[row][column])
                return true;
            else if (target < matrix[row][column])
                column--;
            else
                row++;
        }

        return false;
    }
}
```
time complexity:O（m+n）


[title]: https://leetcode.com/problems/search-a-2d-matrix-ii/description/