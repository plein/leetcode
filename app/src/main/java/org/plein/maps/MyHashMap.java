package org.plein.maps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/design-hashmap/description/
 */
public class MyHashMap {

    int[] array;
    Set<Integer> keys;
    
    public MyHashMap() {
        array = new int[100];
        keys = new HashSet<>();
    }
    
    public void put(int key, int value) {
        if (key > array.length) {
            array = Arrays.copyOf(array, key*2);
        }
        array[key] = value;
        keys.add(key);
    }
    
    public int get(int key) {
        if (keys.contains(key)) {
            return array[key];
        }
        return -1;
        
    }
    
    public void remove(int key) {
        keys.remove(key);
        
    }

}
