package org.example.e_hash_map_set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("1657. Determine if Two Strings Are Close (Optimized)")
class DetermineIfTwoStringsAreCloseOptimizedTest {

    private DetermineIfTwoStringsAreCloseOptimized solution;

    @BeforeEach
    void setUp() {
        solution = new DetermineIfTwoStringsAreCloseOptimized();
    }

    @Test
    @DisplayName("Example 1: word1='abc', word2='bca' → true")
    void example1_anagrams_returnsTrue() {
        assertTrue(solution.closeStrings("abc", "bca"));
    }

    @Test
    @DisplayName("Example 2: word1='a', word2='aa' → false")
    void example2_differentLengths_returnsFalse() {
        assertFalse(solution.closeStrings("a", "aa"));
    }

    @Test
    @DisplayName("Example 3: word1='cabbba', word2='abbccc' → true")
    void example3_sameFrequencyDistribution_returnsTrue() {
        assertTrue(solution.closeStrings("cabbba", "abbccc"));
    }

    @Test
    @DisplayName("Different character sets → false")
    void differentCharacterSets_returnsFalse() {
        assertFalse(solution.closeStrings("abc", "def"));
    }

    @Test
    @DisplayName("Partial character overlap → false")
    void partialOverlap_returnsFalse() {
        assertFalse(solution.closeStrings("abc", "abd"));
    }

    @Test
    @DisplayName("Identical strings → true")
    void identicalStrings_returnsTrue() {
        assertTrue(solution.closeStrings("hello", "hello"));
    }

    @Test
    @DisplayName("Single character same → true")
    void singleCharSame_returnsTrue() {
        assertTrue(solution.closeStrings("a", "a"));
    }

    @Test
    @DisplayName("Same chars different frequency distribution → false")
    void sameCharsDifferentFrequencies_returnsFalse() {
        assertFalse(solution.closeStrings("aabbcc", "aaabbc"));
    }
}