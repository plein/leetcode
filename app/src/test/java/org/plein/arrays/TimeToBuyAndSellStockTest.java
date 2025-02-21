package org.plein.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TimeToBuyAndSellStockTest {

    private TimeToBuyAndSellStock timeToBuyAndSellStock;

    @BeforeEach
    void setup() {
        timeToBuyAndSellStock = new TimeToBuyAndSellStock();
    }
    

    @Test
    void case1() {
        assertEquals(5, timeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, timeToBuyAndSellStock.maxProfit(new int[]{3,2,6,5,0,3}));
    }
}
