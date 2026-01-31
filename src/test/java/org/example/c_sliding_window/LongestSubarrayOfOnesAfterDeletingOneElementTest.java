package org.example.c_sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LongestSubarrayOfOnesAfterDeletingOneElementTest {

    private LongestSubarrayOfOnesAfterDeletingOneElement longestSubarray;

    @BeforeEach
    void setUp() {
        longestSubarray = new LongestSubarrayOfOnesAfterDeletingOneElement();
    }

    @Test
    @DisplayName("Example 1: nums=[1,1,0,1] returns 3")
    void longestSubarray_example1() {
        assertEquals(3, longestSubarray.longestSubarray(new int[]{1, 1, 0, 1}));
    }

    @Test
    @DisplayName("Example 2: nums=[0,1,1,1,0,1,1,0,1] returns 5")
    void longestSubarray_example2() {
        assertEquals(5, longestSubarray.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
    }

    @Test
    @DisplayName("Example 3: nums=[1,1,1] returns 2")
    void longestSubarray_example3() {
        assertEquals(2, longestSubarray.longestSubarray(new int[]{1, 1, 1}));
    }

    @Test
    @DisplayName("All zeros")
    void longestSubarray_allZeros() {
        assertEquals(0, longestSubarray.longestSubarray(new int[]{0, 0, 0, 0}));
    }

    @Test
    @DisplayName("Single element one")
    void longestSubarray_singleOne() {
        assertEquals(0, longestSubarray.longestSubarray(new int[]{1}));
    }

    @Test
    @DisplayName("Single element zero")
    void longestSubarray_singleZero() {
        assertEquals(0, longestSubarray.longestSubarray(new int[]{0}));
    }

    @Test
    @DisplayName("Two ones")
    void longestSubarray_twoOnes() {
        assertEquals(1, longestSubarray.longestSubarray(new int[]{1, 1}));
    }

    @Test
    @DisplayName("One and zero")
    void longestSubarray_oneAndZero() {
        assertEquals(1, longestSubarray.longestSubarray(new int[]{1, 0}));
    }

    @Test
    @DisplayName("Zero and one")
    void longestSubarray_zeroAndOne() {
        assertEquals(1, longestSubarray.longestSubarray(new int[]{0, 1}));
    }

    @Test
    @DisplayName("Alternating ones and zeros")
    void longestSubarray_alternating() {
        assertEquals(2, longestSubarray.longestSubarray(new int[]{1, 0, 1, 0, 1, 0, 1}));
    }

    @Test
    @DisplayName("Ones at the beginning, zeros at the end")
    void longestSubarray_onesAtBeginning() {
        assertEquals(3, longestSubarray.longestSubarray(new int[]{1, 1, 1, 0, 0, 0}));
    }

    @Test
    @DisplayName("Zeros at the beginning, ones at the end")
    void longestSubarray_onesAtEnd() {
        assertEquals(3, longestSubarray.longestSubarray(new int[]{0, 0, 0, 1, 1, 1}));
    }

    @Test
    @DisplayName("Single zero in the middle")
    void longestSubarray_singleZeroMiddle() {
        assertEquals(4, longestSubarray.longestSubarray(new int[]{1, 1, 0, 1, 1}));
    }

    @Test
    @DisplayName("Two zeros in the middle")
    void longestSubarray_twoZerosMiddle() {
        assertEquals(2, longestSubarray.longestSubarray(new int[]{1, 1, 0, 0, 1, 1}));
    }

    @Test
    @DisplayName("Multiple groups of ones")
    void longestSubarray_multipleGroups() {
        assertEquals(3, longestSubarray.longestSubarray(new int[]{1, 0, 1, 1, 0, 1}));
    }

    @Test
    @DisplayName("Long array of all ones")
    void longestSubarray_longAllOnes() {
        assertEquals(9, longestSubarray.longestSubarray(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    @DisplayName("Best subarray at the end")
    void longestSubarray_bestAtEnd() {
        assertEquals(4, longestSubarray.longestSubarray(new int[]{0, 0, 1, 1, 0, 1, 1}));
    }

    @Test
    @DisplayName("Best subarray at the beginning")
    void longestSubarray_bestAtBeginning() {
        assertEquals(4, longestSubarray.longestSubarray(new int[]{1, 1, 0, 1, 1, 0, 0}));
    }
}