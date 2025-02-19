package org.plein.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    
    /**
     * https://leetcode.com/problems/group-anagrams/
     * 
     * Simple solution that sort the words and use the hashcode to group the anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> groups = new HashMap<>();

        for (String current : strs) {
            char[] sorted = current.toCharArray();
            Arrays.sort(sorted);
            int hash = Arrays.hashCode(sorted); // Using the hashcode is more optimal than building the sorted string from the array.
            groups.computeIfAbsent(hash, k -> new ArrayList<>()).add(current);
        }
        
        return new ArrayList<>(groups.values());
    }
}
