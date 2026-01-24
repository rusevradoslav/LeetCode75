package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IncreasingTripletSubsequenceTest {

    private IncreasingTripletSubsequence tripletSubsequence;

    @BeforeEach
    void setUp() {
        tripletSubsequence = new IncreasingTripletSubsequence();
    }

    @Test
    @DisplayName("Returns true for strictly increasing sequence")
    void increasingTriplet_strictlyIncreasing() {
        int[] nums = {1, 2, 3, 4, 5};
        assertTrue(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns false for strictly decreasing sequence")
    void increasingTriplet_strictlyDecreasing() {
        int[] nums = {5, 4, 3, 2, 1};
        assertFalse(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns true when a non-consecutive increasing triplet exists")
    void increasingTriplet_nonConsecutiveTriplet() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        assertTrue(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns false when array length is less than 3")
    void increasingTriplet_lessThanThreeElements() {
        int[] nums = {1, 2};
        assertFalse(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns false when all elements are equal")
    void increasingTriplet_allEqualElements() {
        int[] nums = {2, 2, 2, 2};
        assertFalse(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Handles negative numbers correctly")
    void increasingTriplet_withNegativeNumbers() {
        int[] nums = {-5, -4, -3, -2};
        assertTrue(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns false when duplicates prevent a strictly increasing triplet")
    void increasingTriplet_duplicatesOnly() {
        int[] nums = {1, 1, 1, 1};
        assertFalse(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns true for increasing triplet at the end")
    void increasingTriplet_atTheEnd() {
        int[] nums = {9, 8, 1, 2, 3};
        assertTrue(tripletSubsequence.increasingTriplet(nums));
    }

    @Test
    @DisplayName("Returns false when no valid increasing triplet exists")
    void increasingTriplet_noValidTriplet() {
        int[] nums = {2, 4, 1, 3};
        assertFalse(tripletSubsequence.increasingTriplet(nums));
    }
}
