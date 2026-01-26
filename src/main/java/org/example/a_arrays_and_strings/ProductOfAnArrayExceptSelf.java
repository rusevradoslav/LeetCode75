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
 * <p>Example with {@code [2, 3, 4, 5]}:
 * <pre>
 * Index:           0    1    2    3
 * Original:        2    3    4    5
 *
 * prefixProducts:  1    2    6   24
 * suffixProducts: 60   20    5    1
 *
 * result:         60   40   30   24
 * </pre>
 *
 * <p><b>Why prefix and suffix arrays start with 1:</b>
 * <ul>
 *   <li>{@code prefixProducts[0] = 1} because there are no elements to the left
 *       of index 0. Using 1 (the multiplicative identity) means "no contribution"
 *       — multiplying by 1 doesn't change the result.</li>
 *   <li>{@code suffixProducts[n-1] = 1} for the same reason: there are no elements
 *       to the right of the last index.</li>
 *   <li>Using 0 would break the calculation since any number multiplied by 0 is 0.</li>
 * </ul>
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
