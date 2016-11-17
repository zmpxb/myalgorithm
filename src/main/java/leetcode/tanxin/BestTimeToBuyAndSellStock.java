package leetcode.tanxin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaozl on 2016/10/19.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int [] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit11(prices,6,9));
    }

    /**
     * 这样做会超时，时间复杂度为n*n
     * @param prices
     * @return
     */
    public  static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1){
            return 0;
        }
        int profit = 0;
        int profit1 = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit1 = prices[j] - prices[i];
                profit = Math.max(profit1,profit);
            }
        }
        return profit;
    }

    /**
     *  Best Time to Buy and Sell Stock
     *  Say you have an array for which the i-th element is the price of a given stock on day i.
     If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the
     stock), design an algorithm to find the maximum profit.
     *  买股票，prices[i]表示当前的股价，只能先买后卖，只能进行一次交易，球最大收益
     *  低价买高价出。每次都能够获取一个最优解profit，profit = prices[i] - cur_min;通过比较保留当前最优解在之前最优解中最好的情况
     * 时间复杂度为n
     * @param prices
     * @return
     */
    public  static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int profit = 0;
        int cur_min = prices[0];
        // i由 0 到 prices.length-1 ,一步一步进行
        for (int i = 0; i < prices.length; i++) {
            // profit为最大增益
            profit = Math.max(profit,prices[i]-cur_min); // 做出选择，每次选择都是在可以买入股票的最小价格，和未知买入股票直接做出的。
            // 通过i和cur_min的不断变化做出选择
            // 在遍历数组是判断当前价格是否为最低价格，cur_min 和 当前的prices[i]
            cur_min = Math.min(cur_min,prices[i]);
        }
        return profit;
    }

    /**
     * Best Time to Buy and Sell Stock II
     􁣾􄔟
     Say you have an array for which the i-th element is the price of a given stock on day i.
     Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie,
     buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions
     at the same time (ie, you must sell the stock before you buy again).
     * 买卖股票的第二题。与1的变化在于可以买卖任意次数，但必须保证买卖一次后才能进行第二次。必须是买、卖、买
     *
     * 将所有的局部最优解求和，最好局部最优解怎么处理也是一个问题。
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int profit = 0;
        int cur_min = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            cur_min = prices[i-1];
            profit = prices[i] - cur_min;
            if (profit>0){
                sum = sum + profit;
            }
        }
        return sum;
    }

    /**
     * 这样做会超时，用动态规划
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int profit = 0;
        int profit1 = 0;
        int profit2 = 0;
        for (int i = 0; i < prices.length; i++) {
            profit1 = maxProfit11(prices,0,i-1);
            profit2 = maxProfit11(prices,i, prices.length-1);
            profit =  Math.max(profit,profit1+profit2);
        }
        return profit;
    }

    public  static int maxProfit11(int[] prices,int m,int n) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        if (m>=n){
            return 0;
        }
        int profit = 0;
        int cur_min = prices[m];
        for (int i = m; i <= n; i++) {
            // profit为最大增益
            profit = Math.max(profit,prices[i]-cur_min);
            // 在遍历数组是判断当前价格是否为最低价格，cur_min 和 当前的prices[i]
            cur_min = Math.min(cur_min,prices[i]);
        }
        return profit;
    }

}
