package org.plein.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubNoRepeatChar {
    
    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/
     * 
     * Iterate over each element from left to right.
     * We keep track of each char last apearance. 
     * If we find a duplicated. We move the pointer to the following position of the last appearance. 
     * Or we leave at it is we is before the current pointer position.
     * Each iteration we calculate the distance between the pointer and current position.
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int pointer = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer prev = charMap.put(s.charAt(i), i);
            if (prev != null) {
                pointer = Math.max(pointer, prev + 1);
            }
            maxLength = Math.max(maxLength, i - pointer + 1);
        }
        return maxLength;
    }

}
