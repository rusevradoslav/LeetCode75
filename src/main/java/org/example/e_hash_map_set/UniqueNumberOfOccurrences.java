package org.example.e_hash_map_set;

import java.util.HashMap;
import java.util.Map;

/**
 * Determines if all values in an array have unique occurrence counts.
 *
 * <p>Given an integer array {@code arr}, return {@code true} if the number of
 * occurrences of each value is unique, or {@code false} otherwise.
 *
 * <p>The algorithm uses a HashMap and Stream approach:
 * <ul>
 *   <li>Count occurrences of each value using a HashMap</li>
 *   <li>Extract the occurrence counts (map values)</li>
 *   <li>Count distinct occurrence values using Stream</li>
 *   <li>Compare: if distinct count equals map size, all counts are unique</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the array. Building the frequency map requires
 * one pass, and counting distinct values is O(k) where k is the number of unique elements.
 *
 * <p>Space Complexity:
 * O(k), where k is the number of distinct values in the array, for storing the frequency map.
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        long distinctCounter = map.values().stream().distinct().count();
        return map.size() == distinctCounter;
    }
}
