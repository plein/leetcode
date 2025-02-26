package org.plein.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KClosestPointsTest {
    
    @Test
    void testBase7() {
        assertEquals(new int[][]{{-2,2}}, new KClosestPoints().kClosest(new int[][]{{1,3},{-2,2}}, 1));
    }
}
