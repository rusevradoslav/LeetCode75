package org.example.a_arrays_and_strings;

/**
 * Compresses the input character array in-place using run-length encoding.
 *
 * <p>For each group of consecutive repeating characters:
 * <ul>
 *   <li>Write the character once.</li>
 *   <li>If the group length is greater than 1, write the group length as digits.</li>
 * </ul>
 *
 * <p>The compressed output is stored in the same {@code chars} array starting at index 0.
 * The method returns the length of the compressed content. Characters beyond the returned
 * length are not important.
 *
 * <p>Example:
 * <pre>
 *  chars = ['a','a','b','b','c','c','c']
 *  result array prefix = ['a','2','b','2','c','3']
 *  return value = 6
 * </pre>
 *
 * <p>Approach:
 * <ul>
 *   <li>{@code currentIndex} scans the array and counts the size of each consecutive group.</li>
 *   <li>{@code result} is the write index where we overwrite the array with compressed data.</li>
 *   <li>After counting a group of size {@code counter}, write the character and (if needed) the digits of {@code counter}.</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n), where n is {@code chars.length}. Each character is read a constant number of times.
 * <p>Space Complexity:
 * O(1) extra space because the compression is written directly into the input array and the algorithm
 *  * uses only a fixed number of variables ({@code currentIndex}, {@code result}, {@code counter}).
 *
 * @param chars the input character array to compress (modified in-place)
 * @return the length of the compressed content written into {@code chars}
 */


public class StringCompression {

    public int compress(char[] chars) {
        int currentIndex = 0;
        int result = 0;

        while (currentIndex < chars.length) {

            int counter = 1;
            while (currentIndex + counter < chars.length && chars[currentIndex + counter] == chars[currentIndex]) {
                counter++;
            }
            chars[result++] = chars[currentIndex];

            if (counter > 1) {
                char[] counterCharacters = Integer.toString(counter).toCharArray();
                for (char counterCharacter : counterCharacters) {
                    chars[result++] = counterCharacter;
                }
            }
            currentIndex += counter;
        }
        return result;
    }
}
