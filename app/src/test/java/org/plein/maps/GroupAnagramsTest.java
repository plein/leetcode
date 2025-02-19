package org.plein.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupAnagramsTest {
    
    private GroupAnagrams groupAnagrams;

    @BeforeEach
    void init() {
        groupAnagrams = new GroupAnagrams();
    }

    @Test
    void examples() {
       assertThat(
        groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}),
        containsInAnyOrder(
            containsInAnyOrder( "tea", "ate", "eat"),
            containsInAnyOrder("tan", "nat"),
            containsInAnyOrder("bat")
        )
       );
    }
    
}
