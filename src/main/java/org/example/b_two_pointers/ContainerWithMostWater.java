package org.example.b_two_pointers;


/**
 * Finds the maximum amount of water a container can store.
 *
 * <p>Given an integer array {@code height} of length {@code n}, where each element
 * represents the height of a vertical line at that index. Find two lines that
 * together with the x-axis form a container that holds the most water.
 *
 * <p>The algorithm uses a two-pointer approach:
 * <ul>
 *   <li>{@code left} starts at the beginning of the array</li>
 *   <li>{@code right} starts at the end of the array</li>
 *   <li>Calculate area as {@code minBucket * distance}, where {@code minBucket} is the shorter
 *   of the two lines (water spills over the shorter side) and {@code distance} is the distance between the two pointers</li>
 *   <li>Move the pointer pointing to the shorter line inward</li>
 *   <li>Track the maximum area found</li>
 * </ul>
 *
 * <p>Example walkthrough for height=[1,8,6,2,5,4,8,3,7]:
 * <pre>
 *   left=0, right=8: min(1,7)*8=8,   max=8,  height[0]&lt;height[8] → left++
 *   left=1, right=8: min(8,7)*7=49,  max=49, height[1]&gt;height[8] → right--
 *   left=1, right=7: min(8,3)*6=18,  max=49, height[1]&gt;height[7] → right--
 *   left=1, right=6: min(8,8)*5=40,  max=49, height[1]==height[6] → right--
 *   left=1, right=5: min(8,4)*4=16,  max=49, height[1]&gt;height[5] → right--
 *   left=1, right=4: min(8,5)*3=15,  max=49, height[1]&gt;height[4] → right--
 *   left=1, right=3: min(8,2)*2=4,   max=49, height[1]&gt;height[3] → right--
 *   left=1, right=2: min(8,6)*1=6,   max=49, height[1]&gt;height[2] → right--
 *   left=1, right=1: loop ends
 *
 *   Result: maxArea = 49
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of height. Each element is visited at most once.
 *
 * <p>Space Complexity:
 * O(1), as only a few integer variables are used.
 *
 * @param height the array of line heights
 * @return the maximum area of water that can be contained
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxAmountIfWater = Integer.MIN_VALUE;

        while (left < right) {
            int leftBucket = height[left];
            int rightBucket = height[right];
            int distance = right - left;
            int minBucket = Math.min(leftBucket, rightBucket);
            int amountOfWater = minBucket * distance;

            if (amountOfWater > maxAmountIfWater) {
                maxAmountIfWater = amountOfWater;
            }

            if (leftBucket < rightBucket) {
                left++;
            } else {
                right--;
            }
        }
        return maxAmountIfWater;
    }
}
