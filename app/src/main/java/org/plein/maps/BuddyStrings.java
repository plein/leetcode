package org.plein.maps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings {


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
