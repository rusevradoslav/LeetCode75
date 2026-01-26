package org.example.a_arrays_and_strings;

/**
 * Determines whether a given number of new flowers can be planted in a flowerbed
 * without violating the no-adjacent-flowers rule.
 *
 * <p>The flowerbed is represented as an array where:
 * <ul>
 *   <li>0 indicates an empty plot</li>
 *   <li>1 indicates an already planted flower</li>
 * </ul>
 *
 * <p>A flower can be planted at position {@code i} only if:
 * <ul>
 *   <li>The current plot is empty</li>
 *   <li>The left neighbor is empty or {@code i} is at the beginning</li>
 *   <li>The right neighbor is empty or {@code i} is at the end</li>
 * </ul>
 *
 * <p>The algorithm uses a greedy approach: whenever a valid position is found,
 * a flower is planted immediately, and the flowerbed is updated to prevent
 * future adjacent placements.
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the flowerbed array. The array is traversed once.
 *
 * <p>Space Complexity:
 * O(1), since the flowerbed is modified in place and no extra data structures
 * are used.
 *
 */

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        for (int i = 0; i < size; i++) {
            boolean left = (i == 0) || (flowerbed[i - 1] == 0);
            boolean right = (i == size - 1 || flowerbed[i + 1] == 0);

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
