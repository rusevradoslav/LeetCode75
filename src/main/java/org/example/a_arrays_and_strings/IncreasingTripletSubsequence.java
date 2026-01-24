package org.example.a_arrays_and_strings;

import java.util.Objects;

/**
 * Determines whether an integer array contains an increasing triplet subsequence.
 *
 * <p>An increasing triplet subsequence exists if there are three indices
 * {@code i < j < k} such that:
 * <pre>
 * nums[i] < nums[j] < nums[k]
 * </pre>
 *
 * <p>This implementation scans the array from right to left and keeps track
 * of two candidates:
 * <ul>
 *   <li>{@code thirdNumber}: the largest value seen so far (rightmost candidate)</li>
 *   <li>{@code secondNumber}: a valid middle value smaller than {@code thirdNumber}</li>
 * </ul>
 *
 * <p>If a number smaller than {@code secondNumber} is found, an increasing
 * triplet subsequence is guaranteed to exist.
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the input array. The array is traversed once.
 *
 * <p>Space Complexity:
 * O(1), since only a constant number of variables are used.
 *
 * @param nums the input array of integers
 * @return {@code true} if an increasing triplet subsequence exists,
 * otherwise {@code false}
 */

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return false;
        }

        int secondNumber = Integer.MIN_VALUE;
        int thirdNumber = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            int currentNumber = nums[i];
            if (currentNumber > thirdNumber) {
                thirdNumber = currentNumber;
                continue;
            }
            if (thirdNumber > currentNumber && currentNumber > secondNumber) {
                secondNumber = currentNumber;
                continue;
            }
            if (secondNumber > currentNumber) {
                return true;
            }
        }
        return false;
    }
}
