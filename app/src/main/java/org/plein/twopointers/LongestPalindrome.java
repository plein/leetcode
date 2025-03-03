package org.plein.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome {


    /**
     * Start from the left. For each character, find the longest palindrom with tha position being the center.
     * Also find the longest palindrom with that character and the next being the center. 
     * Is important to do both checks to find palindroms like 'bab' and algo 'baab'.
     * Stop as soon as no longer palindrom can be found. Using s.substring is expensive, avoid when possible.
     */
    public String longestPalindrome(String s) {

        String result = s.substring(0, 1);

        for (int i = 0; i < (s.length() - result.length() / 2); i++) {
            String even = expand(s, i, i +1, result.length());
            if (even != null) {
                result = even;
            }
            String odd = expand(s, i, i, result.length());
            if (odd != null) {
                result = odd;
            }
            
        }

        return result;
    }

    private String expand(String s, int left, int right, int maxSize) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - (left + 1) > maxSize) {
            return s.substring(left + 1, right);
        }
        return null;
    }

    

    public String longestPalindromeDP(String s) {
        Map<String, Boolean> isPalindromMap = new HashMap<>();

        String result = s.substring(0, 1);
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (j - i + 1 < result.length()) {
                    break;
                }

                if (isPalindrom(s, i, j, isPalindromMap)) {
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

    public boolean isPalindrom(String s, int i, int j, Map<String, Boolean> isPalindromMap) {
        String substring = s.substring(i, j + 1);
        if (isPalindromMap.containsKey(substring)) {
            return isPalindromMap.get(substring);
        }
        if (i >= j) {
            return true;
        }
        else {
            if(s.charAt(i) == s.charAt(j) && isPalindrom(s, i + 1, j - 1, isPalindromMap)) {
                isPalindromMap.put(substring, true);
                return true;
            } else {
                isPalindromMap.put(substring, false);
                return false;
            }
        }
    }


    public String longestPalindromeFirst(String s) {
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
