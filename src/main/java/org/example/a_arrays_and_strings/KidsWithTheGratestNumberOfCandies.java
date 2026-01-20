package org.example.a_arrays_and_strings;

import java.util.ArrayList;
import java.util.List;
/**
 * Determines whether each child can have the greatest number of candies
 * after receiving a given number of extra candies.
 *
 * <p>For each child, this method checks if the number of candies they have
 * plus the extra candies is greater than or equal to the maximum number
 * of candies any child currently has.
 *
 * <p>Time Complexity:
 * O(n), where n is the number of children. One pass is used to find the
 * maximum number of candies, and a second pass is used to build the result.
 *
 * <p>Space Complexity:
 * O(n), where n is the number of children, due to the list storing the result.
 *
 * <p>Approach:
 * <ul>
 *   <li>First, find the maximum number of candies among all children.</li>
 *   <li>For each child, check if their candies plus extraCandies is
 *       greater than or equal to the maximum.</li>
 *   <li>Store the result as a list of booleans.</li>
 * </ul>
 */

public class KidsWithTheGratestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}
