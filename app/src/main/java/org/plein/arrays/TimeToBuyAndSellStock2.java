package org.plein.arrays;

public class TimeToBuyAndSellStock2 {
    
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
     * 
     * Start on the left, if there is an increase of price from one day to the next, add to the total counter.
     * This solution is very simple. If the problem would introduce some fees for operations, the 
     * maxProfitIfFees method below would be more optimal.
     */
    public int maxProfit(int[] prices) {
        int total = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total = total + prices[i] - prices[i - 1];
            }
        }
        return total;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
     * 
     * This solution focus on reducing the amount of buy and sell operation to avoid fees.
     */
    public int maxProfitIfFees(int[] prices) {
        int total = 0;
        int currentLow = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currentLow || prices[i] < prices[i - 1]) {
                total = total + prices[i - 1] - currentLow;
                currentLow = prices[i];
            }
        }
        if (prices[prices.length - 1] > currentLow) {
            total = total + prices[prices.length - 1] - currentLow;
        }
        return total;
    }
}
