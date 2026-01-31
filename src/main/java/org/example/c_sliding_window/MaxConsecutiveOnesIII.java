package org.example.c_sliding_window;
/**
 * Finds the maximum number of consecutive 1's if you can flip at most k 0's.
 *
 * <p>Given a binary array {@code nums} and an integer {@code k}, return the maximum
 * number of consecutive 1's in the array if you can flip at most {@code k} 0's.
 *
 * <p>Key insight: Reframe the problem as "find the longest subarray with at most k zeros".
 * We don't actually flip anything — we just find a window where the zero count is ≤ k.
 *
 * <p>The algorithm uses a variable-size sliding window approach:
 * <ul>
 *   <li>Expand the window by moving {@code right} pointer forward</li>
 *   <li>Track the count of zeros in the current window</li>
 *   <li>When {@code zeroCount > k}, shrink the window from the left until valid</li>
 *   <li>After shrinking, the window is valid — update max length</li>
 * </ul>
 *
 * <p>Example walkthrough for nums=[1,1,1,0,0,0,1,1,1,1,0], k=2:
 * <pre>
 *   right=0: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *             L
 *             R
 *             Window: [1], zeroCount=0, valid, maxLength=1
 *
 *   right=1: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *             L  R
 *             Window: [1,1], zeroCount=0, valid, maxLength=2
 *
 *   right=2: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *             L     R
 *             Window: [1,1,1], zeroCount=0, valid, maxLength=3
 *
 *   right=3: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *             L        R
 *             Window: [1,1,1,0], zeroCount=1, valid, maxLength=4
 *
 *   right=4: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *             L           R
 *             Window: [1,1,1,0,0], zeroCount=2, valid, maxLength=5
 *
 *   right=5: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *             L              R
 *             Window: [1,1,1,0,0,0], zeroCount=3, TOO MANY! shrink...
 *
 *             Shrink: nums[left]=1 (not zero), left++
 *            [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                L           R
 *             zeroCount=3, still too many! shrink...
 *
 *             Shrink: nums[left]=1 (not zero), left++
 *            [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                   L        R
 *             zeroCount=3, still too many! shrink...
 *
 *             Shrink: nums[left]=1 (not zero), left++
 *            [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                      L     R
 *             zeroCount=3, still too many! shrink...
 *
 *             Shrink: nums[left]=0 (zero!), zeroCount--, left++
 *            [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                         L  R
 *             zeroCount=2, valid, maxLength=5
 *
 *   right=6: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                         L     R
 *             Window: [0,0,1], zeroCount=2, valid, maxLength=5
 *
 *   right=7: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                         L        R
 *             Window: [0,0,1,1], zeroCount=2, valid, maxLength=5
 *
 *   right=8: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                         L           R
 *             Window: [0,0,1,1,1], zeroCount=2, valid, maxLength=5
 *
 *   right=9: [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                         L              R
 *             Window: [0,0,1,1,1,1], zeroCount=2, valid, maxLength=6
 *
 *   right=10:[1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                         L                 R
 *             Window: [0,0,1,1,1,1,0], zeroCount=3, TOO MANY! shrink...
 *
 *             Shrink: nums[left]=0 (zero!), zeroCount--, left++
 *            [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
 *                            L              R
 *             zeroCount=2, valid, maxLength=6
 *
 *   Result: maxLength = 6
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
 * @param k the maximum number of 0's that can be flipped
 * @return the maximum number of consecutive 1's after flipping at most k 0's
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            int currentElement = nums[right];
            if (currentElement == 0) {
                zeroCount++;
            }

            if (zeroCount <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }

            while (zeroCount > k) {
                int leftNumber = nums[left];
                if (leftNumber == 0) {
                    zeroCount--;
                }
                left++;
            }
        }
        return maxLength;
    }

}
