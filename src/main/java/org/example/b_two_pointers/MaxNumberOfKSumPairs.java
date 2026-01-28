package org.example.b_two_pointers;

import java.util.Arrays;

/**
 * Finds the maximum number of k-sum pairs that can be removed from an array.
 *
 * <p>Given an integer array {@code nums} and an integer {@code k}, in one operation
 * you can pick two numbers from the array whose sum equals {@code k} and remove them.
 * Return the maximum number of operations you can perform on the array.
 *
 * <p>The algorithm uses a two-pointer approach:
 * <ul>
 *   <li>Sort the array to enable two-pointer traversal</li>
 *   <li>{@code left} starts at the beginning of the array</li>
 *   <li>{@code right} starts at the end of the array</li>
 *   <li>Calculate {@code sum} as {@code nums[left] + nums[right]}</li>
 *   <li>If {@code sum == k}: found a pair, increment count, move both pointers inward</li>
 *   <li>If {@code sum < k}: need a larger sum, move {@code left} right</li>
 *   <li>If {@code sum > k}: need a smaller sum, move {@code right} left</li>
 * </ul>
 *
 * <p>Example walkthrough for nums=[1,2,3,4], k=5:
 * <pre>
 *   After sorting: [1, 2, 3, 4]
 *
 *   left=0, right=3: 1+4=5 == k → pair found! count=1, left++, right--
 *   left=1, right=2: 2+3=5 == k → pair found! count=2, left++, right--
 *   left=2, right=1: loop ends (left >= right)
 *
 *   Result: count = 2
 * </pre>
 *
 * <p>Example walkthrough for nums=[3,1,3,4,3], k=6:
 * <pre>
 *   After sorting: [1, 3, 3, 3, 4]
 *
 *   left=0, right=4: 1+4=5 < k → left++
 *   left=1, right=4: 3+4=7 > k → right--
 *   left=1, right=3: 3+3=6 == k → pair found! count=1, left++, right--
 *   left=2, right=2: loop ends (left >= right)
 *
 *   Result: count = 1
 * </pre>
 *
 * <p>Time Complexity:
 * O(n log n), dominated by the sorting step. The two-pointer traversal is O(n).
 *
 * <p>Space Complexity:
 * O(1) extra space (or O(n) depending on the sorting algorithm used).
 *
 * @param nums the array of integers
 * @param k the target sum for each pair
 * @return the maximum number of pairs that sum to k
 */
public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
