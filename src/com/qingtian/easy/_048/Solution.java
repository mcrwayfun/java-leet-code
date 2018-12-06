package com.qingtian.easy._048;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/5/22
 */
public class Solution {

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


    public static void main(String[] args) {
        int[][] matrix =
                {
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}
                };

        int[][] matrix1 =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9},
                };

        new Solution().rotate(matrix1);

        int rows = matrix1.length;
        int columns = matrix1[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf(matrix1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
