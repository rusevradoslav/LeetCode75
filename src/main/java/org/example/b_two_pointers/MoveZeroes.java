package org.example.b_two_pointers;
/**
 * Moves all zeros in an array to the end while maintaining the relative order of non-zero elements.
 *
 * <p>The algorithm uses a slow/fast two-pointer approach:
 * <ul>
 *   <li>{@code slow} tracks the position where the next non-zero element should be placed</li>
 *   <li>{@code fast} scans through the array looking for non-zero elements</li>
 *   <li>When a non-zero element is found at {@code fast}, it is swapped with the element at {@code slow}</li>
 * </ul>
 *
 * <p>Example walkthrough for [0, 1, 0, 3, 12]:
 * <pre>
 *   fast=0: nums[0]=0, skip                          → [0, 1, 0, 3, 12], slow=0
 *   fast=1: nums[1]=1≠0, swap(0,1), slow++           → [1, 0, 0, 3, 12], slow=1
 *   fast=2: nums[2]=0, skip                          → [1, 0, 0, 3, 12], slow=1
 *   fast=3: nums[3]=3≠0, swap(1,3), slow++           → [1, 3, 0, 0, 12], slow=2
 *   fast=4: nums[4]=12≠0, swap(2,4), slow++          → [1, 3, 12, 0, 0], slow=3
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the array. Each element is visited exactly once.
 *
 * <p>Space Complexity:
 * O(1), as the operation is performed in-place using only two pointers.
 *
 * @param nums the input array to be modified in-place
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swapNumbers(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    private static void swapNumbers(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
