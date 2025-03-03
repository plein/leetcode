package org.plein.set;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/design-hashset/description/
 */
public class MyHashSet {

    char[] set;

    public MyHashSet() {
        set = new char[100];
    }
    
    public void add(int key) {
        if (key > set.length) {
            set = Arrays.copyOf(set, Math.max(key * 2, 1000001));
        }
        set[key] = 'a';
    }
    
    public void remove(int key) {
        if (key < set.length){
            set[key] = 'x';
        }
    }
    
    public boolean contains(int key) {
        return set.length > key && set[key] == 'a';
    }
}
