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
 * <p>Example with {@code [1, 2, 3, 4]}:
 * <pre>
 * Index:           0    1    2    3
 * Original:        1    2    3    4
 *
 * prefixProducts:  1    1    2    6
 * suffixProducts: 24   12    4    1
 *
 * result:         24   12    8    6
 * </pre>
 *
 * <p>Two implementations are provided:
 *
 * <p><b>{@code productExceptSelf}</b> - Standard approach
 * <ul>
 *   <li>Builds separate prefix and suffix arrays</li>
 *   <li>Time Complexity: O(n) - three passes through the array</li>
 *   <li>Space Complexity: O(n) - two auxiliary arrays of size n</li>
 * </ul>
 *
 * <p><b>{@code productExceptSelfSpaceOptimized}</b> - Space-optimized approach
 * <ul>
 *   <li>Stores prefix products directly in result array</li>
 *   <li>Computes suffix on the fly using a single running variable</li>
 *   <li>Time Complexity: O(n) - two passes through the array</li>
 *   <li>Space Complexity: O(1) extra space, excluding the output array</li>
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

    public int[] productExceptSelfWithBetterSpaceComplexity(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}
