package org.plein.twopointers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ThreeSumTest {
    
    private ThreeSum threeSum;

    @BeforeEach
    void setup() {
        threeSum = new ThreeSum();
    }

    @Test
    void testBase1() {
        assertThat(
            threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}),
            containsInAnyOrder(
                containsInAnyOrder(-1,-1,2),
                containsInAnyOrder(-1,0,1)
            )
       );
    }

    @Test
    void testBase2() {
        assertThat(
            threeSum.threeSum(new int[]{0,1,1}),
            is(empty())
       );
    }

    @Test
    void testBase3() {
        assertThat(
            threeSum.threeSum(new int[]{0,0,0,0}),
            containsInAnyOrder(
                containsInAnyOrder(0,0,0)
            )
       );
    }

    @Test
    void testBase4() {
        assertThat(
            threeSum.threeSum(new int[]{1,1,-2}),
            containsInAnyOrder(
                containsInAnyOrder(-2,1,1)
            )
       );
    }

    @Test
    void testBase5() {
        assertThat(
            threeSum.threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}),
            containsInAnyOrder(
                containsInAnyOrder(-4,0,4),
                containsInAnyOrder(-4,1,3),
                containsInAnyOrder(-3,-1,4),
                containsInAnyOrder(-3,0,3),
                containsInAnyOrder(-3,1,2),
                containsInAnyOrder(-2,-1,3),
                containsInAnyOrder(-2,0,2),
                containsInAnyOrder(-1,-1,2),
                containsInAnyOrder(-1,0,1)
            )
       );
    }

    @Test
    void testBase6() {
        assertThat(
            threeSum.threeSum(new int[]{-1,0,1,5,6,7,8,9,10}),
            containsInAnyOrder(
                containsInAnyOrder(-1,0,1)
            )
       );
    }

}
