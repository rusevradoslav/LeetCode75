package org.example.e_hash_map_set;

import java.util.Arrays;

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
 * <p>The algorithm uses a fixed-size array approach:
 * <ul>
 *   <li>Early exit if lengths differ</li>
 *   <li>Use int[26] arrays for frequency counting (lowercase letters only)</li>
 *   <li>Check that both strings use the exact same character set</li>
 *   <li>Sort and compare frequency arrays</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * word1 = "cabbba"    word2 = "abbccc"
 *
 * Step 1: Build frequency arrays
 *   word1: a→2, b→3, c→1    [2, 3, 1, 0, 0, ...]
 *   word2: a→1, b→2, c→3    [1, 2, 3, 0, 0, ...]
 *
 * Step 2: Check same character set
 *   word1 has: {a, b, c}
 *   word2 has: {a, b, c}    ✓ Match
 *
 * Step 3: Sort and compare frequencies
 *   word1 sorted: [0, 0, ..., 1, 2, 3]
 *   word2 sorted: [0, 0, ..., 1, 2, 3]    ✓ Match
 *
 * Result: true (strings are close)
 * </pre>
 *
 * <p>Key insight: Operation 1 allows any character arrangement, and Operation 2
 * allows swapping frequency counts between characters. So two strings are close
 * if they have the same characters and the same multiset of frequencies.
 *
 * <p>Time Complexity:
 * O(n), where n is the string length. Frequency counting is O(n), and sorting
 * the fixed-size array (26 elements) is O(1).
 *
 * <p>Space Complexity:
 * O(1), since the arrays are fixed size (26 elements) regardless of input.
 */
public class DetermineIfTwoStringsAreCloseOptimized {

    private static final int ALPHABET_SIZE = 26;
    private static final char BASE_CHAR = 'a';

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] frequencyWord1 = buildFrequencyArray(word1);
        int[] frequencyWord2 = buildFrequencyArray(word2);

        if (!hasSameCharacterSet(frequencyWord1, frequencyWord2)) {
            return false;
        }

        return hasSameFrequencyDistribution(frequencyWord1, frequencyWord2);
    }

    private int[] buildFrequencyArray(String word) {
        int[] frequency = new int[ALPHABET_SIZE];
        for (char character : word.toCharArray()) {
            int index = character - BASE_CHAR;
            frequency[index]++;
        }
        return frequency;
    }

    private boolean hasSameCharacterSet(int[] frequency1, int[] frequency2) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            boolean existsInFirst = frequency1[i] > 0;
            boolean existsInSecond = frequency2[i] > 0;
            if (existsInFirst != existsInSecond) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSameFrequencyDistribution(int[] frequency1, int[] frequency2) {
        Arrays.sort(frequency1);
        Arrays.sort(frequency2);
        return Arrays.equals(frequency1, frequency2);
    }
}