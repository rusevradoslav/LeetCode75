package org.example.b_two_pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxNumberOfKSumPairsTest {

    private MaxNumberOfKSumPairs maxNumberOfKSumPairs;

    @BeforeEach
    void setUp() {
        maxNumberOfKSumPairs = new MaxNumberOfKSumPairs();
    }

    @Test
    @DisplayName("Example 1: nums=[1,2,3,4], k=5 returns 2")
    void maxOperations_example1() {
        assertEquals(2, maxNumberOfKSumPairs.maxOperations(new int[]{1, 2, 3, 4}, 5));
    }

    @Test
    @DisplayName("Example 2: nums=[3,1,3,4,3], k=6 returns 1")
    void maxOperations_example2() {
        assertEquals(1, maxNumberOfKSumPairs.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }

    @Test
    @DisplayName("Single element array returns 0")
    void maxOperations_singleElement() {
        assertEquals(0, maxNumberOfKSumPairs.maxOperations(new int[]{5}, 5));
    }

    @Test
    @DisplayName("Two elements that sum to k returns 1")
    void maxOperations_twoElementsMatch() {
        assertEquals(1, maxNumberOfKSumPairs.maxOperations(new int[]{2, 3}, 5));
    }

    @Test
    @DisplayName("Two elements that don't sum to k returns 0")
    void maxOperations_twoElementsNoMatch() {
        assertEquals(0, maxNumberOfKSumPairs.maxOperations(new int[]{2, 4}, 5));
    }

    @Test
    @DisplayName("All elements are the same and sum to k")
    void maxOperations_allSameElementsSumToK() {
        assertEquals(3, maxNumberOfKSumPairs.maxOperations(new int[]{3, 3, 3, 3, 3, 3}, 6));
    }

    @Test
    @DisplayName("All elements are the same but don't sum to k")
    void maxOperations_allSameElementsNoMatch() {
        assertEquals(0, maxNumberOfKSumPairs.maxOperations(new int[]{3, 3, 3, 3}, 5));
    }

    @Test
    @DisplayName("No pairs sum to k")
    void maxOperations_noPairs() {
        assertEquals(0, maxNumberOfKSumPairs.maxOperations(new int[]{1, 2, 3, 4}, 10));
    }

    @Test
    @DisplayName("Multiple pairs with duplicates")
    void maxOperations_multiplePairsWithDuplicates() {
        assertEquals(2, maxNumberOfKSumPairs.maxOperations(new int[]{1, 1, 4, 4}, 5));
    }

    @Test
    @DisplayName("k is larger than any possible pair sum")
    void maxOperations_kTooLarge() {
        assertEquals(0, maxNumberOfKSumPairs.maxOperations(new int[]{1, 2, 3}, 100));
    }

    @Test
    @DisplayName("k equals smallest possible pair sum")
    void maxOperations_kEqualsSmallestSum() {
        assertEquals(1, maxNumberOfKSumPairs.maxOperations(new int[]{1, 1, 5, 5}, 2));
    }

    @Test
    @DisplayName("Array with odd number of matching elements")
    void maxOperations_oddNumberOfMatchingElements() {
        assertEquals(2, maxNumberOfKSumPairs.maxOperations(new int[]{2, 2, 2, 2, 2}, 4));
    }

    @Test
    @DisplayName("Unsorted array")
    void maxOperations_unsortedArray() {
        assertEquals(2, maxNumberOfKSumPairs.maxOperations(new int[]{4, 1, 3, 2}, 5));
    }

    @Test
    @DisplayName("Large values that sum to k")
    void maxOperations_largeValues() {
        assertEquals(1, maxNumberOfKSumPairs.maxOperations(new int[]{1000000000, 1}, 1000000001));
    }

    @Test
    @DisplayName("All pairs can be matched")
    void maxOperations_allPairsMatch() {
        assertEquals(3, maxNumberOfKSumPairs.maxOperations(new int[]{1, 9, 2, 8, 3, 7}, 10));
    }

    @Test
    @DisplayName("Element cannot pair with itself when k is double")
    void maxOperations_singleElementCannotPairWithItself() {
        assertEquals(0, maxNumberOfKSumPairs.maxOperations(new int[]{5}, 10));
    }

    @Test
    @DisplayName("Mixed scenario with some pairs matching")
    void maxOperations_mixedScenario() {
        assertEquals(3, maxNumberOfKSumPairs.maxOperations(new int[]{2, 5, 4, 3, 1, 6}, 7));
    }
}