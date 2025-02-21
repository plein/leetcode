package org.plein.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeToBuyAndSellStock2Test {

    private TimeToBuyAndSellStock2 timeToBuyAndSellStock;

    @BeforeEach
    void setup() {
        timeToBuyAndSellStock = new TimeToBuyAndSellStock2();
    }
    

    @Test
    void maxProfit_examples() {
        assertEquals(7, timeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, timeToBuyAndSellStock.maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, timeToBuyAndSellStock.maxProfit(new int[]{7,6,4,3,1}));
    }

    @Test
    void maxProfit2_examples() {
        assertEquals(7, timeToBuyAndSellStock.maxProfitIfFees(new int[]{7,1,5,3,6,4}));
        assertEquals(4, timeToBuyAndSellStock.maxProfitIfFees(new int[]{1,2,3,4,5}));
        assertEquals(0, timeToBuyAndSellStock.maxProfitIfFees(new int[]{7,6,4,3,1}));
    }
}
