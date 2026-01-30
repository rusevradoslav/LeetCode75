package org.example.c_sliding_window;

/**
 * Finds the maximum number of vowels in any substring of length k.
 *
 * <p>Given a string {@code s} and an integer {@code k}, return the maximum number of
 * vowel letters in any substring of {@code s} with length {@code k}.
 * Vowel letters are 'a', 'e', 'i', 'o', and 'u'.
 *
 * <p>The algorithm uses a fixed-size sliding window approach:
 * <ul>
 *   <li>Count vowels in the first window of size {@code k}</li>
 *   <li>Slide the window one position at a time across the string</li>
 *   <li>For each slide: if entering character is a vowel, increment count</li>
 *   <li>For each slide: if leaving character is a vowel, decrement count</li>
 *   <li>Track the maximum vowel count found across all window positions</li>
 * </ul>
 *
 * <p>Example walkthrough for s="abciiidef", k=3:
 * <pre>
 *   Step 1: Count vowels in first window
 *   [a, b, c] i, i, i, d, e, f    vowelCount = 1 (a), maxCount = 1
 *
 *   Step 2: Slide the window
 *   i=3: a [b, c, i] i, i, d, e, f
 *        'a' leaves (vowel) → count--
 *        'i' enters (vowel) → count++
 *        vowelCount = 1 - 1 + 1 = 1, maxCount = 1
 *
 *   i=4: a, b [c, i, i] i, d, e, f
 *        'b' leaves (not vowel) → no change
 *        'i' enters (vowel) → count++
 *        vowelCount = 1 + 1 = 2, maxCount = 2
 *
 *   i=5: a, b, c [i, i, i] d, e, f
 *        'c' leaves (not vowel) → no change
 *        'i' enters (vowel) → count++
 *        vowelCount = 2 + 1 = 3, maxCount = 3
 *
 *   i=6: a, b, c, i [i, i, d] e, f
 *        'i' leaves (vowel) → count--
 *        'd' enters (not vowel) → no change
 *        vowelCount = 3 - 1 = 2, maxCount = 3
 *
 *   ... continue until end
 *
 *   Result: maxCount = 3
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the string. Each character is visited at most twice
 * (once when entering the window, once when leaving).
 *
 * <p>Space Complexity:
 * O(n) for the character array conversion, or O(1) if using charAt() directly.
 *
 * @param s the input string consisting of lowercase English letters
 * @param k the size of the substring window
 * @return the maximum number of vowels in any substring of length k
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String string, int k) {
        char[] array = string.toCharArray();
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(array[i])) {
                windowSum++;
            }
        }

        int maxSum = windowSum;
        for (int i = k; i < array.length; i++) {
            if (isVowel(array[i])) {
                windowSum++;
            }
            if (isVowel(array[i - k])) {
                windowSum--;
            }
            maxSum = Math.max(maxSum, windowSum);

        }
        return maxSum;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
