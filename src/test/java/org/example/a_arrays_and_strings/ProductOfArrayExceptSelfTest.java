package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductOfArrayExceptSelfTest {

    private ProductOfAnArrayExceptSelf productOfAnArrayExceptSelf;

    @BeforeEach
    void setUp() {
        productOfAnArrayExceptSelf = new ProductOfAnArrayExceptSelf();
    }

    @Test
    @DisplayName("Basic example with positive numbers")
    void productExceptSelf_basicExample() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Array containing one zero")
    void productExceptSelf_singleZero() {
        int[] nums = {1, 2, 0, 4};
        int[] expected = {0, 0, 8, 0};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Array containing multiple zeros")
    void productExceptSelf_multipleZeros() {
        int[] nums = {0, 1, 0, 3};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Array with negative numbers")
    void productExceptSelf_negativeNumbers() {
        int[] nums = {-1, 1, -3, 3};
        int[] expected = {-9, 9, -3, 3};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Minimum length array")
    void productExceptSelf_twoElements() {
        int[] nums = {5, 10};
        int[] expected = {10, 5};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    @DisplayName("All elements are the same")
    void productExceptSelf_sameElements() {
        int[] nums = {2, 2, 2, 2};
        int[] expected = {8, 8, 8, 8};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }

    @Test
    @DisplayName("Array containing ones")
    void productExceptSelf_containsOnes() {
        int[] nums = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }


    @Test
    @DisplayName("Simple test")
    void productExceptSelf_simpleTest() {
        int[] nums = {10, 3, 5, 2};
        int[] expected = {30, 100, 60, 150};

        assertArrayEquals(expected, productOfAnArrayExceptSelf.productExceptSelf(nums));
    }
}
