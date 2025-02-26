package org.plein.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        Map<Character, List<Integer>> charPosMap = new HashMap<>();

        if (s.length() == 1) {
            return s;
        }
        
        for (int i = 0; i < s.length(); i++) {
            charPosMap.computeIfAbsent(s.charAt(i), ArrayList::new).add(i);
        }   

        int max = 1;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() && s.length() - i > max; i++) {
            char charAt = s.charAt(i);
            List<Integer> positions = charPosMap.get(charAt);
            positions.remove(0);
            for (int j = positions.size() - 1; j >= 0; j-- ) {
                if (positions.get(j) - i >= max) {
                    String sub = s.substring(i, positions.get(j) + 1);
                    if (isPalindrom(sub)) {
                        max = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrom(String sub) {
        for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
            if (sub.charAt(i) != sub.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
