package org.example.e_hash_map_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Finds the distinct elements unique to each of two arrays.
 *
 * <p>Given two integer arrays {@code nums1} and {@code nums2}, return a list of two lists:
 * the first contains all distinct integers in {@code nums1} not present in {@code nums2},
 * the second contains all distinct integers in {@code nums2} not present in {@code nums1}.
 * Elements may be returned in any order.
 *
 * <p>The algorithm uses a HashSet approach:
 * <ul>
 *   <li>Convert both arrays to HashSets (eliminates duplicates)</li>
 *   <li>Create a list from each set</li>
 *   <li>Remove elements present in the other set using {@code removeAll}</li>
 *   <li>Return both resulting lists</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n + m), where n and m are the lengths of nums1 and nums2.
 * Building sets is O(n + m), and removeAll operates in O(n) or O(m) with HashSet lookups.
 *
 * <p>Space Complexity:
 * O(n + m) for storing the two HashSets and resulting lists.
 */
public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> firstList = new HashSet<>();
        for (int num : nums1) {
            firstList.add(num);
        }
        Set<Integer> secondList = new HashSet<>();
        for (int num : nums2) {
            secondList.add(num);
        }

        List<Integer> firstSet = new ArrayList<>(firstList);
        firstSet.removeAll(secondList);

        List<Integer> secondSet = new ArrayList<>(secondList);
        secondSet.removeAll(firstList);

        return List.of(firstSet, secondSet);
    }
}
