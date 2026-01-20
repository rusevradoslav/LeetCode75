package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CanPlaceFlowersTest {

    private CanPlaceFlowers canPlaceFlowers;

    @BeforeEach
    void setUp() {
        canPlaceFlowers = new CanPlaceFlowers();
    }

    @Test
    @DisplayName("Returns true when one flower can be planted between two empty plots")
    void canPlaceFlowers_singlePlacementPossible() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertTrue(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("Returns false when two flowers cannot be planted")
    void canPlaceFlowers_multiplePlacementsNotPossible() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertFalse(canPlaceFlowers.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    @DisplayName("Allows planting at the beginning of the flowerbed")
    void canPlaceFlowers_plantAtBeginning() {
        int[] flowerbed = {0, 0, 1};
        assertTrue(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("Allows planting at the end of the flowerbed")
    void canPlaceFlowers_plantAtEnd() {
        int[] flowerbed = {1, 0, 0};
        assertTrue(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("Returns false when no empty plots exist")
    void canPlaceFlowers_noEmptyPlots() {
        int[] flowerbed = {1, 1, 1};
        assertFalse(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("Handles single plot with one flower to plant")
    void canPlaceFlowers_singlePlotCanPlant() {
        int[] flowerbed = {0};
        assertTrue(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("Handles single plot with too many flowers requested")
    void canPlaceFlowers_singlePlotTooManyRequested() {
        int[] flowerbed = {0};
        assertFalse(canPlaceFlowers.canPlaceFlowers(flowerbed, 2));
    }

    @Test
    @DisplayName("Returns true when zero flowers are requested")
    void canPlaceFlowers_zeroFlowersRequested() {
        int[] flowerbed = {1, 0, 1};
        assertTrue(canPlaceFlowers.canPlaceFlowers(flowerbed, 0));
    }

    @Test
    @DisplayName("Returns false when adjacent constraint blocks all placements")
    void canPlaceFlowers_adjacentConstraintBlocksPlacement() {
        int[] flowerbed = {0, 1, 0};
        assertFalse(canPlaceFlowers.canPlaceFlowers(flowerbed, 1));
    }

    @Test
    @DisplayName("Returns false when only one flower can be planted but two are requested")
    void canPlaceFlowers_twoRequestedButOnlyOnePossible() {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;

        assertFalse(canPlaceFlowers.canPlaceFlowers(flowerbed, n));
    }
}
