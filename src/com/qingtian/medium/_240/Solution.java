package com.qingtian.medium._240;

/**
 * @author mcrwayfun
 * @version v1.0
 * @date Created in 2018/07/12
 * @description
 */
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

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {18, 21, 23, 26, 30}
        };

        int target = 5;

        boolean b = new Solution().searchMatrix(matrix, target);
        System.out.println(b);
    }

}
