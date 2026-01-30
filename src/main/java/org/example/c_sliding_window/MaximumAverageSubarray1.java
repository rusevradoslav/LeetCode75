package org.example.c_sliding_window;

/**
 * Finds the maximum average of any contiguous subarray of length k.
 *
 * <p>Given an integer array {@code nums} and an integer {@code k}, find the contiguous
 * subarray of length {@code k} that has the maximum average value and return this value.
 *
 * <p>The algorithm uses a sliding window approach:
 * <ul>
 *   <li>Calculate the sum of the first {@code k} elements as the initial window</li>
 *   <li>Slide the window one position at a time across the array</li>
 *   <li>For each slide: add the entering element, subtract the leaving element</li>
 *   <li>Track the maximum sum found across all window positions</li>
 *   <li>Return the maximum sum divided by {@code k} to get the average</li>
 * </ul>
 *
 * <p>Example walkthrough for nums=[2,5,3,8,1,6], k=3:
 * <pre>
 *   Step 1: Calculate first window sum
 *   [2, 5, 3] 8, 1, 6    windowSum = 2+5+3 = 10, maxSum = 10
 *
 *   Step 2: Slide the window
 *   i=3: 2 [5, 3, 8] 1, 6    windowSum = 10 - 2 + 8 = 16, maxSum = 16
 *   i=4: 2, 5 [3, 8, 1] 6    windowSum = 16 - 5 + 1 = 12, maxSum = 16
 *   i=5: 2, 5, 3 [8, 1, 6]   windowSum = 12 - 3 + 6 = 15, maxSum = 16
 *
 *   Result: maxSum / k = 16 / 3 = 5.33333
 * </pre>
 *
 * <p>Why sliding window works:
 * <pre>
 *   Instead of recalculating the sum for each window (O(k) per window),
 *   we reuse the previous sum:
 *
 *   new_sum = old_sum - element_leaving + element_entering
 *
 *   This reduces each window calculation from O(k) to O(1).
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of nums. Each element is visited at most twice
 * (once when entering the window, once when leaving).
 *
 * <p>Space Complexity:
 * O(1), as only a few variables are used regardless of input size.
 *
 * @param nums the array of integers
 * @param k the size of the subarray window
 * @return the maximum average value of any contiguous subarray of length k
 */
public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return nums[0];
        }

        double windowSum = 0.0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum / k;
    }
}
