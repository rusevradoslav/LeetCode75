package org.example.a_arrays_and_strings;

/**
 * Returns an array where each element at index {@code i} is the product of
 * all elements in the input array except {@code nums[i]}.
 *
 * <p>The solution does not use division and runs in linear time by leveraging
 * prefix and suffix products.
 *
 * <p>Prefix products represent the product of all elements to the left of
 * a given index. Suffix products represent the product of all elements to
 * the right of a given index.
 *
 * <p>For each index {@code i}, the final result is computed as:
 * <pre>
 * result[i] = prefixProducts[i] * suffixProducts[i]
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the input array. The array is traversed
 * a constant number of times.
 *
 * <p>Space Complexity:
 * O(n), due to the additional prefix and suffix arrays used to store
 * intermediate products.
 *
 * <p>Approach:
 * <ul>
 *   <li>Build a prefix product array from left to right.</li>
 *   <li>Build a suffix product array from right to left.</li>
 *   <li>Multiply corresponding prefix and suffix values to form the result.</li>
 * </ul>
 *
 * @param nums the input array of integers
 * @return an array where each element is the product of all other elements
 */

public class ProductOfAnArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixProducts[i] = 1;
            } else {
                prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffixProducts[i] = 1;
            } else {
                suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }
        return result;
    }
}
