package org.example.e_hash_map_set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DetermineIfTwoStringsAreCloseTest {

    private DetermineIfTwoStringsAreClose solution;

    @BeforeEach
    void setUp() {
        solution = new DetermineIfTwoStringsAreClose();
    }

    @Test
    @DisplayName("Example 1: word1='abc', word2='bca' → true (swap operations)")
    void example1_anagrams_returnsTrue() {
        assertTrue(solution.closeStrings("abc", "bca"));
    }

    @Test
    @DisplayName("Example 2: word1='a', word2='aa' → false (different lengths)")
    void example2_differentLengths_returnsFalse() {
        assertFalse(solution.closeStrings("a", "aa"));
    }

    @Test
    @DisplayName("Example 3: word1='cabbba', word2='abbccc' → true (transform operations)")
    void example3_sameFrequencyDistribution_returnsTrue() {
        assertTrue(solution.closeStrings("cabbba", "abbccc"));
    }

    @Test
    @DisplayName("Different character sets → false")
    void differentCharacterSets_returnsFalse() {
        assertFalse(solution.closeStrings("abc", "def"));
    }

    @Test
    @DisplayName("Same frequencies but different characters → false")
    void sameFrequenciesDifferentChars_returnsFalse() {
        assertFalse(solution.closeStrings("aabbcc", "ddeeff"));
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
    @DisplayName("Single character different → false")
    void singleCharDifferent_returnsFalse() {
        assertFalse(solution.closeStrings("a", "b"));
    }

    @Test
    @DisplayName("Same chars different frequency distribution → false")
    void sameCharsDifferentFrequencies_returnsFalse() {
        assertFalse(solution.closeStrings("aabbcc", "aaabbc"));
    }

    @Test
    @DisplayName("All same character → true")
    void allSameCharacter_returnsTrue() {
        assertTrue(solution.closeStrings("aaaa", "aaaa"));
    }

    @Test
    @DisplayName("Frequency swap possible → true")
    void frequencySwapPossible_returnsTrue() {
        assertTrue(solution.closeStrings("aabb", "bbaa"));
    }
}