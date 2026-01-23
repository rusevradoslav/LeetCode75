package org.example.a_arrays_and_strings;

/**
 * Reverses the order of words in a given string.
 *
 * <p>A word is defined as a sequence of non-space characters. The input
 * string may contain leading, trailing, or multiple spaces between words.
 * The returned string contains the words in reverse order, separated by
 * a single space, with no leading or trailing spaces.
 *
 * <p>The algorithm works by:
 * <ul>
 *   <li>Trimming leading and trailing spaces</li>
 *   <li>Splitting the string using one or more whitespace characters</li>
 *   <li>Appending the words in reverse order</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the input string. Each character is
 * processed a constant number of times.
 *
 * <p>Space Complexity:
 * O(n), due to the array created by splitting the string and the
 * StringBuilder used to construct the result.
 *
 * @param s the input string
 * @return a string containing the words in reverse order, separated by
 * a single space
 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
