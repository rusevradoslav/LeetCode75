package org.example.d_prefix_sum;

/**
 * Finds the highest altitude reached during a road trip.
 *
 * <p>Given an integer array {@code gain} of length {@code n}, where {@code gain[i]}
 * represents the net altitude change between points {@code i} and {@code i+1},
 * return the highest altitude of any point. The biker starts at point 0 with altitude 0.
 *
 * <p>The algorithm uses a prefix sum approach:
 * <ul>
 *   <li>Initialize current altitude at 0 (starting point)</li>
 *   <li>Iterate through each gain value, adding it to the running altitude</li>
 *   <li>Track the maximum altitude encountered at each step</li>
 *   <li>Compare final maximum with starting altitude 0 and return the greater</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the gain array. Each element is visited exactly once.
 *
 * <p>Space Complexity:
 * O(1) for the optimized solution using a running prefix sum, or
 * O(n) for the explicit altitude array approach.
 *
 */
public class FindTheHighestAltitude {

    public int largestAltitudeOptimised(int[] gain) {
        int max = Integer.MIN_VALUE;
        int prefix = 0;
        for (int element : gain) {
            prefix += element;
            max = Math.max(max, prefix);
        }
        return Math.max(max, 0);
    }

    public int largestAltitude(int[] gain) {
        int[] result = new int[gain.length + 1];
        result[0] = 0;
        int max = 0;

        for (int i = 1; i < result.length; i++) {
            int resultElement = result[i - 1];
            int gainElement = gain[i - 1];

            result[i] = resultElement + gainElement;
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
