package org.example.e_hash_map_set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UniqueNumberOfOccurrencesTest {

    private UniqueNumberOfOccurrences solution;

    @BeforeEach
    void setUp(){
        solution = new UniqueNumberOfOccurrences();
    }

    @Test
    @DisplayName("Example 1: arr=[1,2,2,1,1,3] → true (counts: 3,2,1 all unique)")
    void example1_uniqueCounts_returnsTrue() {
        assertTrue(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    @Test
    @DisplayName("Example 2: arr=[1,2] → false (both have count 1)")
    void example2_sameCounts_returnsFalse() {
        assertFalse(solution.uniqueOccurrences(new int[]{1, 2}));
    }

    @Test
    @DisplayName("Example 3: arr=[-3,0,1,-3,1,1,1,-3,10,0] → true")
    void example3_mixedWithNegatives_returnsTrue() {
        assertTrue(solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    @Test
    @DisplayName("Single element → true (one unique count)")
    void singleElement_alwaysUnique_returnsTrue() {
        assertTrue(solution.uniqueOccurrences(new int[]{5}));
    }

    @Test
    @DisplayName("All same elements → true (single count)")
    void allSameElements_singleCount_returnsTrue() {
        assertTrue(solution.uniqueOccurrences(new int[]{7, 7, 7, 7}));
    }

    @Test
    @DisplayName("Three elements with same count → false")
    void threeDistinctSameCount_returnsFalse() {
        assertFalse(solution.uniqueOccurrences(new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("Two pairs with same counts → false")
    void twoPairsSameCount_returnsFalse() {
        assertFalse(solution.uniqueOccurrences(new int[]{1, 1, 2, 2}));
    }

    @Test
    @DisplayName("Negative numbers with unique counts → true")
    void negativeNumbers_uniqueCounts_returnsTrue() {
        assertTrue(solution.uniqueOccurrences(new int[]{-1, -1, -2}));
    }

    @Test
    @DisplayName("Zero included with unique counts → true")
    void zeroIncluded_uniqueCounts_returnsTrue() {
        assertTrue(solution.uniqueOccurrences(new int[]{0, 0, 0, 1, 1, 2}));
    }

    @Test
    @DisplayName("Large counts but duplicated → false")
    void largeDuplicatedCounts_returnsFalse() {
        assertFalse(solution.uniqueOccurrences(new int[]{1, 1, 1, 2, 2, 2}));
    }
}