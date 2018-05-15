# [Best Time to Buy and Sell Stock II][title]

## Description

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

**Note:** You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy 
again).

**Example 1:**

```
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
```
**Example 2:**
```
Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
```

**Example 3:**
```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```

**Tags:** Array

## 解读题意
i从1开始，表示第几天，array[i-1]表示当天的进价或者售价，问题是求最大利润。要先进货才能卖，可以进行多次买卖。

## 思路1 

sub = 后一天的价格减去前一天的价格，如果大于0则maxProfit加上sub，循环到天数结束。如果买和卖是同一天，则等于没卖。

```java
class Solution {
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
}
```



[title]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/