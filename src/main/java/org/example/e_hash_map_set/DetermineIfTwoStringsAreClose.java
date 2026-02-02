package org.example.e_hash_map_set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Determines if two strings are "close" using swap and transform operations.
 *
 * <p>Two strings are considered close if one can be transformed into the other using:
 * <ul>
 *   <li>Operation 1: Swap any two existing characters (e.g., "abc" → "bac")</li>
 *   <li>Operation 2: Transform every occurrence of one character into another,
 *       and vice versa (e.g., "aacabb" → "bbcbaa")</li>
 * </ul>
 *
 * <p>The algorithm uses a frequency map approach:
 * <ul>
 *   <li>Early exit if lengths differ (no operations can change length)</li>
 *   <li>Build frequency maps for both strings</li>
 *   <li>Check that both strings use the exact same character set</li>
 *   <li>Check that sorted frequency distributions match</li>
 * </ul>
 *
 * <p>Key insight: Operation 1 allows any character arrangement, and Operation 2
 * allows swapping frequency counts between characters. So two strings are close
 * if they have the same characters and the same multiset of frequencies.
 *
 * <p>Time Complexity:
 * O(n + k log k), where n is the string length and k is the number of unique characters.
 * Building maps is O(n), sorting frequencies is O(k log k), where k ≤ 26 for lowercase letters.
 *
 * <p>Space Complexity:
 * O(k) for the frequency maps and lists, where k is the number of unique characters.
 */
public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for (char character : word1.toCharArray()) {
            map1.put(character, map1.getOrDefault(character, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char character : word2.toCharArray()) {
            map2.put(character, map2.getOrDefault(character, 0) + 1);
        }

        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        List<Integer> firstSequence = new ArrayList<>(map1.values().stream().toList());
        List<Integer> secondSequence = new ArrayList<>(map2.values().stream().toList());

        Collections.sort(firstSequence);
        Collections.sort(secondSequence);
        return firstSequence.equals(secondSequence);
    }
}
