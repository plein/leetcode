package org.plein.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    /**
     * https://leetcode.com/problems/3sum/description
     * 
     * Sort the array. For each negative or 0 value, try to find two elements that sum the target.
     * Use two pointers on the right side of the array. Skip duplicate numbers to avoid duplicated solutions.
     */
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return List.of();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    
    public List<List<Integer>> threeSumFirst(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> counterMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counterMap.merge(nums[i], 1, (v, x) -> v + 1);
        }

        List<Integer> sortedElements = new ArrayList<>(counterMap.keySet());
        Collections.sort(sortedElements);

        int left = 0;
        int right = sortedElements.size() - 1;

        while (left < right && sortedElements.get(left) <= 0) {
            while (Math.abs(sortedElements.get(left)) > 2 * sortedElements.get(right) && left < right) {
                left++;
            }

            while (Math.abs(sortedElements.get(left)) * 2  < sortedElements.get(right) && left < right) {
                right--;
            }

            int currentRight = right;
            while (Math.abs(sortedElements.get(left)) <= 2 * sortedElements.get(currentRight) && left < currentRight) {
                int leftNum = sortedElements.get(left);
                int rightNum = sortedElements.get(currentRight);
                int target = (rightNum + leftNum) * -1;
                if (target < leftNum) {
                    currentRight--;
                    continue;
                }
                int required = (target == rightNum && target == leftNum) 
                    ? 3 
                    : ((target == rightNum || target == leftNum) 
                        ? 2 
                        : 1);
                if (counterMap.getOrDefault(target, 0) >= required) {
                    result.add(List.of(leftNum, target, rightNum));
                }
                currentRight--;
            }
            left++;
        }
        if (counterMap.getOrDefault(0, 0) > 2) {
            result.add(List.of(0, 0, 0));
        }
        return result;
    }

    
}
