package org.plein.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    
    @Test
    void case1() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }

    @Test
    void case2() {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        assertEquals(2, cache.get(3));
        assertEquals(1, cache.get(2));
        cache.put(4, 3);
        assertEquals(1, cache.get(2));
        assertEquals(-1, cache.get(3));
        assertEquals(3, cache.get(4));
    }
}
