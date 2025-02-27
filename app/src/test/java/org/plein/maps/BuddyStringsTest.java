package org.plein.maps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BuddyStringsTest {
    
    @Test
    void testSwap() {
        assertEquals(false, new BuddyStrings().buddyStrings("abac", "abad"));
        assertEquals(true, new BuddyStrings().buddyStrings("ab", "ba"));
        assertEquals(false, new BuddyStrings().buddyStrings("ab", "ab"));
        assertEquals(true, new BuddyStrings().buddyStrings("aa", "aa"));
        assertEquals(true, new BuddyStrings().buddyStrings("hellothere", "hellothere"));
        assertEquals(true, new BuddyStrings().buddyStrings("hetlolhere", "hellothere"));
        assertEquals(false, new BuddyStrings().buddyStrings("therehello", "hellothere"));
        ;
    }
}
