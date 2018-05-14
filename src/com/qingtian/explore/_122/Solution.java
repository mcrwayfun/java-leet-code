package com.qingtian.explore._122;

/**
 * @Author mcrwayfun
 * @Description
 * @Date Created in 2018/05/14
 */
public class Solution {


    public int maxProfit(int[] prices) {

        // 最大利润
        int maxProfit = 0;
        // 获取最大利润
        for (int i = 1; i < prices.length; i++) {
            // 数组指针
            int j = i - 1;
            // 进货价
            int min = prices[j];
            // 卖出价
            int max = prices[j + 1];
            // 计算最大利润
            maxProfit += max - min > 0 ? max - min : 0;
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {1, 2, 3, 4, 5};
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }

}
