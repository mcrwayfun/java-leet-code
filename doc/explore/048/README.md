# [Rotate Image][title]

## Description

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

**Example 1:**

```
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```
**Example 2:**
```
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```

**Note:**
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

**Tags:** Array

## 解读题意
将给定的二维数组顺时针旋转90°
## 思路1 
    1 2 3				7 8 9				7 4 1			
    4 5 6	convert     4 5 6	convert	 8 5 2	  
    7 8 9				1 2 3			    9 6 3

先将数组翻转，再将数组对称交换，即得到答案。
```java
class Solution {
   public void rotate(int[][] matrix) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        // 将数组翻转
        reverse(matrix, rows);
        // 对称交换
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < columns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverse(int[][] matrix, int rows) {

        for (int i = 0, j = rows - 1; i < j; i++, j--) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

    }
}
```
分析：
- Time complexity：O(n^2)


[title]: https://leetcode.com/problems/rotate-image/description/