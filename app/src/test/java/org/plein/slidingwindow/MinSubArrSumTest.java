package org.plein.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinSubArrSumTest {
    
    private MinSubArrSum minSubArrSum;

    @BeforeEach
    void setup() {
        minSubArrSum = new MinSubArrSum();
    }

    @Test
    void testBase() {
        assertEquals(2, minSubArrSum.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        assertEquals(1, minSubArrSum.minSubArrayLen(4, new int[]{1,4,4}));
        assertEquals(0, minSubArrSum.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        assertEquals(8, minSubArrSum.minSubArrayLen(8, new int[]{1,1,1,1,1,1,1,1}));
    }
}
