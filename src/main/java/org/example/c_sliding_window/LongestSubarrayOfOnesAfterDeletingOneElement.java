package org.example.c_sliding_window;

/**
 * Finds the longest subarray of 1's after deleting exactly one element.
 *
 * <p>Given a binary array {@code nums}, you must delete one element from it.
 * Return the size of the longest non-empty subarray containing only 1's in the
 * resulting array. Return 0 if there is no such subarray.
 *
 * <p>Key insight: Reframe the problem as "find the longest subarray with at most 1 zero".
 * Since we must delete one element, the result is the window length minus 1 (or just
 * don't count the zero in the window).
 *
 * <p>The algorithm uses a variable-size sliding window approach:
 * <ul>
 *   <li>Expand the window by moving {@code right} pointer forward</li>
 *   <li>Track the count of zeros in the current window</li>
 *   <li>When {@code counter <= 1}, window is valid — update max length</li>
 *   <li>When {@code counter > 1}, shrink from the left until valid</li>
 *   <li>Use {@code right - left} (not +1) because we must delete one element</li>
 * </ul>
 *
 * <p>Example walkthrough for nums=[1,1,0,1]:
 * <pre>
 *   right=0: [1, 1, 0, 1]
 *             L
 *             R
 *             Window: [1], counter=0, valid, maxLength=max(0, 0-0)=0
 *
 *   right=1: [1, 1, 0, 1]
 *             L  R
 *             Window: [1,1], counter=0, valid, maxLength=max(0, 1-0)=1
 *
 *   right=2: [1, 1, 0, 1]
 *             L     R
 *             Window: [1,1,0], counter=1, valid, maxLength=max(1, 2-0)=2
 *
 *   right=3: [1, 1, 0, 1]
 *             L        R
 *             Window: [1,1,0,1], counter=1, valid, maxLength=max(2, 3-0)=3
 *
 *   Result: maxLength = 3
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of nums. Each element is visited at most twice
 * (once by right pointer, once by left pointer).
 *
 * <p>Space Complexity:
 * O(1), as only a few variables are used regardless of input size.
 *
 * @param nums the binary array containing only 0's and 1's
 * @return the length of the longest subarray of 1's after deleting one element
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int left = 0;
        int maxLength = 0;
        int counter = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentElement = nums[right];
            if (currentElement == 0) {
                counter++;
            }

            if (counter <= 1) {
                maxLength = Math.max(maxLength, right - left);
            } else {
                int leftNumber = nums[left];
                if (leftNumber == 0) {
                    counter--;
                }
                left++;
            }
        }

        return maxLength;
    }
}