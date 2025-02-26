package org.plein.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
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
