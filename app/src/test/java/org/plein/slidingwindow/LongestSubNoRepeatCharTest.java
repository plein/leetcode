package org.plein.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongestSubNoRepeatCharTest {

    private LongestSubNoRepeatChar longestSubNoRepeatChar;

    @BeforeEach
    void setup() {
        longestSubNoRepeatChar = new LongestSubNoRepeatChar();
    }
    
    @Test
    void testbase() {
        // assertEquals(3, longestSubNoRepeatChar.lengthOfLongestSubstring("abcabcbb"));
        // assertEquals(1, longestSubNoRepeatChar.lengthOfLongestSubstring("bbbb"));
        // assertEquals(3, longestSubNoRepeatChar.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, longestSubNoRepeatChar.lengthOfLongestSubstring("dvdf"));
    }
}
