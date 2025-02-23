package org.plein.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubNoRepeatChar {
    
    public int lengthOfLongestSubstring(String s) {
        
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 1;


        Set<Character> current = new HashSet<>();

        while (right < s.length()) {
            if (current.add(s.charAt(right))) {
                right++;
            } else {
                max = Math.max(max, right - left);
                current.remove(s.charAt(left));
                left++;
            }
        }

       
        return Math.max(max, right - left);
    }

    private int getStartWindowSize(String s) {
        Set<Character> seen = new HashSet<>();
        seen.add(s.charAt(0));
        
        int max = 1;
        int current = 1;

        for (int i = 1; i < s.length(); i++) {
            if (!seen.add(s.charAt(i))) {
                // Start again
                max = Math.max(max, current);
                seen = new HashSet<>();
                seen.add(s.charAt(i));
                current = 1;
            } else {
                current++;
            }
        }
        return Math.max(max, current);
    }
}
