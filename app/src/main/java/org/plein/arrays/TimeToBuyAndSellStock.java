package org.plein.arrays;

public class TimeToBuyAndSellStock {
    
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
     * 
     * Start on the left, keep track of the min price found. for each iteration calculate
     * the profit if selling now. Just kepp the max profit.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

}
