package com.xsb.offer;

/**
 * @author shibao.xing
 * @since 2020-04-04 18:09
 *
 * 题目：股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class Question63 {

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 这种方法我是想不出来
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Question63 question63 = new Question63();
//        int[] price = new int[]{7, 1, 5, 3, 6, 4};
//        int[] price = new int[]{1, 2, 3};
        int[] price = new int[]{3, 2, 1};
        int i = question63.maxProfit(price);
        System.out.println(i);
    }
}
