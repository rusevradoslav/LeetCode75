package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KidsWithCandiesTest {

    private KidsWithTheGratestNumberOfCandies kidsWithTheGratestNumberOfCandies;

    @BeforeEach
    void setUp() {
        kidsWithTheGratestNumberOfCandies = new KidsWithTheGratestNumberOfCandies();
    }

    @Test
    @DisplayName("Returns true for children who can reach the maximum with extra candies")
    void kidsWithCandies_basicCase() {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> result = kidsWithTheGratestNumberOfCandies.kidsWithCandies(candies, extraCandies);

        assertEquals(List.of(true, true, true, false, true), result);
    }

    @Test
    @DisplayName("All children can reach the maximum")
    void kidsWithCandies_allTrue() {
        int[] candies = {4, 4, 4};
        int extraCandies = 1;

        List<Boolean> result = kidsWithTheGratestNumberOfCandies.kidsWithCandies(candies, extraCandies);

        assertEquals(List.of(true, true, true), result);
    }

    @Test
    @DisplayName("Only one child has the maximum even after extra candies")
    void kidsWithCandies_singleMaximum() {
        int[] candies = {1, 2, 3};
        int extraCandies = 0;

        List<Boolean> result = kidsWithTheGratestNumberOfCandies.kidsWithCandies(candies, extraCandies);

        assertEquals(List.of(false, false, true), result);
    }

    @Test
    @DisplayName("Handles single child case")
    void kidsWithCandies_singleChild() {
        int[] candies = {5};
        int extraCandies = 10;

        List<Boolean> result = kidsWithTheGratestNumberOfCandies.kidsWithCandies(candies, extraCandies);

        assertEquals(List.of(true), result);
    }
}
