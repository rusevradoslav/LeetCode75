package org.example.d_prefix_sum;
/**
 * Finds the pivot index where left sum equals right sum.
 *
 * <p>Given an integer array {@code nums}, return the leftmost pivot index where
 * the sum of all elements strictly to the left equals the sum of all elements
 * strictly to the right. If no such index exists, return -1.
 *
 * <p>Two implementations are provided:
 *
 * <p><b>{@code pivotIndex} — Dual Prefix Sum Arrays:</b>
 * <ul>
 *   <li>Build left prefix sum array (cumulative sum from start)</li>
 *   <li>Build right prefix sum array (cumulative sum from end)</li>
 *   <li>Find first index where both arrays have equal values</li>
 * </ul>
 *
 * <p><b>{@code pivotIndexOptimized} — Single Pass with Total Sum:</b>
 * <ul>
 *   <li>Compute total sum of array</li>
 *   <li>Iterate while maintaining running left sum</li>
 *   <li>Right sum = totalSum - leftSum - nums[i]</li>
 *   <li>Return index when leftSum equals rightSum</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n) for both implementations. Each element is visited a constant number of times.
 *
 * <p>Space Complexity:
 * O(n) for {@code pivotIndex} (two auxiliary arrays), or
 * O(1) for {@code pivotIndexOptimized} (only scalar variables).
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] leftArray = new int[nums.length];
        int leftPrefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            leftPrefixSum += current;
            leftArray[i] = leftPrefixSum;
        }

        int[] rightArray = new int[nums.length];
        int rightPrefixSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            rightPrefixSum += current;
            rightArray[i] = rightPrefixSum;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftArray[i] == rightArray[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndexOptimized(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
