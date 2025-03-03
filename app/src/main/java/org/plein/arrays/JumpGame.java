package org.plein.arrays;

import java.util.Arrays;

public class JumpGame {
    
    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] > 0) {
            return true;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= (nums.length - i - 1)) {
                if (canJump(Arrays.copyOfRange(nums, 0, i + 1))) {
                    return true;
                }
            }
        }    
        return false;
    }

}
