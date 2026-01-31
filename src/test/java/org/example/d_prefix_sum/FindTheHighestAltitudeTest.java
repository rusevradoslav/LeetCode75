package org.example.d_prefix_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheHighestAltitudeTest {

    private FindTheHighestAltitude findTheHighestAltitude;

    @BeforeEach
    void setUp() {
        findTheHighestAltitude = new FindTheHighestAltitude();
    }

    @Test
    @DisplayName("Example 1: gain=[-5,1,5,0,-7] → highest altitude is 1")
    void example1_mixedGains_returnsOne() {
        assertEquals(1, findTheHighestAltitude.largestAltitudeOptimised(new int[]{-5, 1, 5, 0, -7}));
        assertEquals(1, findTheHighestAltitude.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }

    @Test
    @DisplayName("Example 2: gain=[-4,-3,-2,-1,4,3,2] → highest altitude is 0")
    void example2_neverExceedsStart_returnsZero() {
        assertEquals(0, findTheHighestAltitude.largestAltitudeOptimised(new int[]{-4, -3, -2, -1, 4, 3, 2}));
        assertEquals(0, findTheHighestAltitude.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    @Test
    @DisplayName("Single positive gain → returns that altitude")
    void singlePositiveGain_returnsThatValue() {
        assertEquals(5, findTheHighestAltitude.largestAltitudeOptimised(new int[]{5}));
        assertEquals(5, findTheHighestAltitude.largestAltitude(new int[]{5}));
    }

    @Test
    @DisplayName("Single negative gain → returns 0")
    void singleNegativeGain_returnsZero() {
        assertEquals(0, findTheHighestAltitude.largestAltitudeOptimised(new int[]{-5}));
        assertEquals(0, findTheHighestAltitude.largestAltitude(new int[]{-5}));
    }

    @Test
    @DisplayName("All positive gains → highest is final altitude")
    void allPositive_returnsFinalAltitude() {
        assertEquals(15, findTheHighestAltitude.largestAltitudeOptimised(new int[]{1, 2, 3, 4, 5}));
        assertEquals(15, findTheHighestAltitude.largestAltitude(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("All negative gains → highest is 0")
    void allNegative_returnsZero() {
        assertEquals(0, findTheHighestAltitude.largestAltitudeOptimised(new int[]{-1, -2, -3, -4, -5}));
        assertEquals(0, findTheHighestAltitude.largestAltitude(new int[]{-1, -2, -3, -4, -5}));
    }

    @Test
    @DisplayName("Up then down → highest is at peak")
    void upThenDown_returnsPeak() {
        assertEquals(6, findTheHighestAltitude.largestAltitudeOptimised(new int[]{1, 2, 3, -5, -6}));
        assertEquals(6, findTheHighestAltitude.largestAltitude(new int[]{1, 2, 3, -5, -6}));
    }

    @Test
    @DisplayName("Down then up → returns highest point")
    void downThenUp_returnsHighestPoint() {
        assertEquals(3, findTheHighestAltitude.largestAltitudeOptimised(new int[]{-3, -2, 5, 3}));
        assertEquals(3, findTheHighestAltitude.largestAltitude(new int[]{-3, -2, 5, 3}));
    }

    @Test
    @DisplayName("Alternating gains → tracks running max")
    void alternating_tracksRunningMax() {
        assertEquals(2, findTheHighestAltitude.largestAltitudeOptimised(new int[]{2, -1, 1, -1, 1, -1}));
        assertEquals(2, findTheHighestAltitude.largestAltitude(new int[]{2, -1, 1, -1, 1, -1}));
    }
}