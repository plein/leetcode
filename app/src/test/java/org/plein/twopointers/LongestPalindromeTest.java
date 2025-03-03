package org.plein.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LongestPalindromeTest {
 
    @Test
    void testBases() {
        assertEquals("bb", new LongestPalindrome().longestPalindrome("cbbd"));
        assertEquals("aaa", new LongestPalindrome().longestPalindrome("taaabnm"));
        assertEquals("a", new LongestPalindrome().longestPalindrome("ab"));
        assertEquals("a", new LongestPalindrome().longestPalindrome("a"));
        assertEquals("abcba", new LongestPalindrome().longestPalindrome("abcba"));
        assertEquals("abba", new LongestPalindrome().longestPalindrome("abba"));
        assertEquals("jffj", new LongestPalindrome().longestPalindrome("dqlvtrcystnncxjffjrkiiqgtcunbwntqrpqkjepzbxzodeckrbrwzjjuptloypmjgbwioqtjzjjgqpaemgvxkapjgbfhhwltvtqgkozuzvlwetftjeocjqrdwlhdwtgzdhwvmuhvmdpkxnzrrizjntxbbpzwtjryecgfajolalwdzxqtknvvvaxuhanzowlbwjraigvrflcqoormbeexekmqpmuuobseumctsiwhvdohywjaylixqgqookgneokebtmoyaspnzbwqzffyocvcylcjobnzbmhsdprzrgdlyzuutyuwygzeldfewicjnukguisceeopckkoviayrcqanzsryhwqhxjxcpiejojztrxad"));
    }
}
