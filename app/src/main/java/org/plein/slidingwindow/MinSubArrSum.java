package org.plein.slidingwindow;

public class MinSubArrSum {

    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/
     * 
     * Iterate over each element from left to right.
     * We keep track of the current sum. 
     * If we reach the target, we calculate the distance between the pointer and current position.
     * We reduce from current sum the value at pointer position and move pointer. 
     * We do it until the current sum is equal or above the target. Each time calculate distance.
     * Initial size is set to Integer.MAX_VALUE, could be also done using Integer and null value.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int current = 0;
        int pointer = 0;
        int minSize = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            if (current >= target) {
                while (current >= target && pointer <= i) {
                    minSize = Math.min(minSize, i - pointer + 1);
                    current -= nums[pointer];
                    pointer++;
                }
            }
        }
        return (minSize == Integer.MAX_VALUE) ? 0 : minSize;
    }

}
