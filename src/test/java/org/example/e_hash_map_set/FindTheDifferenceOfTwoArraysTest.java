package org.example.e_hash_map_set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("2215. Find the Difference of Two Arrays")
class FindTheDifferenceOfTwoArraysTest {

    private final FindTheDifferenceOfTwoArrays solution = new FindTheDifferenceOfTwoArrays();

    @Test
    @DisplayName("Example 1: nums1=[1,2,3], nums2=[2,4,6] → [[1,3],[4,6]]")
    void example1_partialOverlap_returnsDifferences() {
        List<List<Integer>> result = solution.findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
        assertAll(
            () -> assertTrue(result.getFirst().containsAll(List.of(1, 3)) && result.getFirst().size() == 2),
            () -> assertTrue(result.get(1).containsAll(List.of(4, 6)) && result.get(1).size() == 2)
        );
    }

    @Test
    @DisplayName("Example 2: nums1=[1,2,3,3], nums2=[1,1,2,2] → [[3],[]]")
    void example2_duplicatesInInput_returnsDistinctDifferences() {
        List<List<Integer>> result = solution.findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
        assertAll(
            () -> assertEquals(List.of(3), result.getFirst()),
            () -> assertTrue(result.get(1).isEmpty())
        );
    }

    @Test
    @DisplayName("Identical arrays → both lists empty")
    void identicalArrays_noDifference_returnsTwoEmptyLists() {
        List<List<Integer>> result = solution.findDifference(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertAll(
            () -> assertTrue(result.getFirst().isEmpty()),
            () -> assertTrue(result.get(1).isEmpty())
        );
    }

    @Test
    @DisplayName("No overlap → both arrays returned as-is")
    void noOverlap_completelyDistinct_returnsAllElements() {
        List<List<Integer>> result = solution.findDifference(new int[]{1, 2}, new int[]{3, 4});
        assertAll(
            () -> assertTrue(result.getFirst().containsAll(List.of(1, 2)) && result.getFirst().size() == 2),
            () -> assertTrue(result.get(1).containsAll(List.of(3, 4)) && result.get(1).size() == 2)
        );
    }

    @Test
    @DisplayName("Single element arrays with no overlap")
    void singleElements_noOverlap_returnsBothElements() {
        List<List<Integer>> result = solution.findDifference(new int[]{1}, new int[]{2});
        assertAll(
            () -> assertEquals(List.of(1), result.getFirst()),
            () -> assertEquals(List.of(2), result.get(1))
        );
    }

    @Test
    @DisplayName("Single element arrays with overlap → both empty")
    void singleElements_sameValue_returnsTwoEmptyLists() {
        List<List<Integer>> result = solution.findDifference(new int[]{1}, new int[]{1});
        assertAll(
            () -> assertTrue(result.getFirst().isEmpty()),
            () -> assertTrue(result.get(1).isEmpty())
        );
    }

    @Test
    @DisplayName("Negative numbers handled correctly")
    void negativeNumbers_returnsDifferences() {
        List<List<Integer>> result = solution.findDifference(new int[]{-1, -2, 3}, new int[]{-1, 4, 5});
        assertAll(
            () -> assertTrue(result.getFirst().containsAll(List.of(-2, 3)) && result.getFirst().size() == 2),
            () -> assertTrue(result.get(1).containsAll(List.of(4, 5)) && result.get(1).size() == 2)
        );
    }

    @Test
    @DisplayName("First array subset of second → first list empty")
    void firstSubsetOfSecond_firstListEmpty() {
        List<List<Integer>> result = solution.findDifference(new int[]{1, 2}, new int[]{1, 2, 3, 4});
        assertAll(
            () -> assertTrue(result.getFirst().isEmpty()),
            () -> assertTrue(result.get(1).containsAll(List.of(3, 4)) && result.get(1).size() == 2)
        );
    }

    @Test
    @DisplayName("Second array subset of first → second list empty")
    void secondSubsetOfFirst_secondListEmpty() {
        List<List<Integer>> result = solution.findDifference(new int[]{1, 2, 3, 4}, new int[]{1, 2});
        assertAll(
            () -> assertTrue(result.getFirst().containsAll(List.of(3, 4)) && result.getFirst().size() == 2),
            () -> assertTrue(result.get(1).isEmpty())
        );
    }
}