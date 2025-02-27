package org.plein.maps;

import java.util.ArrayList;
import java.util.List;

public class BuddyStrings {

    /**
     * https://leetcode.com/problems/buddy-strings/
     * 
     * When the strings are equal que need to verify that there is a duplicated char to make the swap possible.
     * When they are different, we iterate over them until we find two different chars. If there are more, there is no solution.
     * If swaping make them the same, we return true.
     */
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length() || s.length() < 2) {
            return false;
        }

        if (s.equals(goal)) {
            // Check for duplicate characters when s == goal
            int size = 'z' - 'a' + 1;
            boolean[] seen = new boolean[size];
            for (char c : s.toCharArray()) {
                if (seen[c - 'a']) {
                    return true; // Found duplicate character
                }
                seen[c - 'a'] = true;
            }
            return false;
        }

        // Find differences
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
                if (diff.size() > 2) {
                    return false;
                }
            }
        }

        // Exactly two differences, and they should be swappable
        return diff.size() == 2 && 
               s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) &&
               s.charAt(diff.get(1)) == goal.charAt(diff.get(0));

    }
}
