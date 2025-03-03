package org.plein.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JumpGameTest {
    
    @Test
    void testJump() {
        assertEquals(true, new JumpGame().canJump(new int[]{2,3,1,1,4}));
        assertEquals(false, new JumpGame().canJump(new int[]{3,2,1,0,4}));
    }
}
