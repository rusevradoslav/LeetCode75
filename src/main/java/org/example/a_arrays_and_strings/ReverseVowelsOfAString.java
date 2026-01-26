package org.example.a_arrays_and_strings;


import java.util.List;

/**
 * Reverses only the vowels in a given string.
 *
 * <p>The relative order of non-vowel characters remains unchanged.
 * Vowels are identified case-insensitively (both lowercase and uppercase).
 *
 * <p>The algorithm uses a two-pointer approach:
 * <ul>
 *   <li>One pointer starts from the beginning of the string</li>
 *   <li>The other pointer starts from the end</li>
 *   <li>Pointers move inward until both point to vowels, which are then swapped</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of the string. Each character is visited at most once.
 *
 * <p>Space Complexity:
 * O(n), due to the use of a character array to build the result.
 *
 * @param s the input string
 * @return a new string with its vowels reversed
 */

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftCharacter = charArray[left];
            char rightCharacter = charArray[right];
            boolean isLeftCharacterAVowel = isVowel(leftCharacter);
            boolean isRightCharacterAVowel = isVowel(rightCharacter);

            if (isLeftCharacterAVowel && isRightCharacterAVowel) {
                charArray[left] = rightCharacter;
                charArray[right] = leftCharacter;
                left++;
                right--;
            } else if (!isLeftCharacterAVowel) {
                left++;
            } else {
                right--;
            }
        }

        return new String(charArray);
    }

    private static boolean isVowel(char character) {
        return "aeiouAEIOU".indexOf(character) != -1;
    }
}
