package org.example.a_arrays_and_strings;

/**
 * Merges two strings by alternating their characters.
 *
 * <p>Starting from index 0, characters are appended alternately from
 * the first and second string. When one string is exhausted, the
 * remaining characters of the other string are appended.
 *
 * <p>Time Complexity:
 * O(n + m), where n is the length of the first string and m is the
 * length of the second string. Each character from both strings is
 * processed exactly once.
 *
 * <p>Space Complexity:
 * O(n + m), due to the StringBuilder used to construct the result.
 *
 * <p>Approach:
 * <ul>
 *   <li>Maintain two pointers, one for each string.</li>
 *   <li>Append characters alternately while either pointer is in range.</li>
 *   <li>Append remaining characters when one string ends.</li>
 * </ul>
 */

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int firstPointer = 0;
        int secondPointer = 0;

        int firstWordLength = word1.length();
        int secondWordLength = word2.length();
        StringBuilder result = new StringBuilder(firstWordLength + secondWordLength);

        while (firstPointer < firstWordLength || secondPointer < secondWordLength) {
            if (firstPointer < firstWordLength) {
                result.append(word1.charAt(firstPointer++));
            }
            if (secondPointer < secondWordLength) {
                result.append(word2.charAt(secondPointer++));
            }
        }
        return result.toString();
    }
}
