package org.example.c_sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaximumNumberOfVowelsInSubstringTest {

    private MaximumNumberOfVowelsInASubstringOfGivenLength maximumNumberOfVowels;

    @BeforeEach
    void setUp() {
        maximumNumberOfVowels = new MaximumNumberOfVowelsInASubstringOfGivenLength();
    }

    @Test
    @DisplayName("Example 1: s='abciiidef', k=3 returns 3")
    void maxVowels_example1() {
        assertEquals(3, maximumNumberOfVowels.maxVowels("abciiidef", 3));
    }

    @Test
    @DisplayName("Example 2: s='aeiou', k=2 returns 2")
    void maxVowels_example2() {
        assertEquals(2, maximumNumberOfVowels.maxVowels("aeiou", 2));
    }

    @Test
    @DisplayName("Example 3: s='leetcode', k=3 returns 2")
    void maxVowels_example3() {
        assertEquals(2, maximumNumberOfVowels.maxVowels("leetcode", 3));
    }

    @Test
    @DisplayName("Single character vowel")
    void maxVowels_singleVowel() {
        assertEquals(1, maximumNumberOfVowels.maxVowels("a", 1));
    }

    @Test
    @DisplayName("Single character consonant")
    void maxVowels_singleConsonant() {
        assertEquals(0, maximumNumberOfVowels.maxVowels("b", 1));
    }

    @Test
    @DisplayName("All vowels")
    void maxVowels_allVowels() {
        assertEquals(5, maximumNumberOfVowels.maxVowels("aeiouaeiou", 5));
    }

    @Test
    @DisplayName("No vowels")
    void maxVowels_noVowels() {
        assertEquals(0, maximumNumberOfVowels.maxVowels("bcdfg", 3));
    }

    @Test
    @DisplayName("k equals 1")
    void maxVowels_kEqualsOne() {
        assertEquals(1, maximumNumberOfVowels.maxVowels("hello", 1));
    }

    @Test
    @DisplayName("Vowels at the beginning")
    void maxVowels_vowelsAtBeginning() {
        assertEquals(3, maximumNumberOfVowels.maxVowels("aeibcd", 3));
    }

    @Test
    @DisplayName("Vowels at the end")
    void maxVowels_vowelsAtEnd() {
        assertEquals(3, maximumNumberOfVowels.maxVowels("bcdaei", 3));
    }

    @Test
    @DisplayName("Vowels in the middle")
    void maxVowels_vowelsInMiddle() {
        assertEquals(3, maximumNumberOfVowels.maxVowels("bcaeijd", 3));
    }

    @Test
    @DisplayName("Alternating vowels and consonants")
    void maxVowels_alternating() {
        assertEquals(2, maximumNumberOfVowels.maxVowels("ababab", 3));
    }

    @Test
    @DisplayName("All same vowel")
    void maxVowels_allSameVowel() {
        assertEquals(4, maximumNumberOfVowels.maxVowels("aaaa", 4));
    }

    @Test
    @DisplayName("Mixed case - only lowercase counts")
    void maxVowels_mixedVowelTypes() {
        assertEquals(2, maximumNumberOfVowels.maxVowels("aexyz", 3));
    }

    @Test
    @DisplayName("Long string with scattered vowels")
    void maxVowels_longStringScatteredVowels() {
        assertEquals(2, maximumNumberOfVowels.maxVowels("abcdefghijklmnop", 5));
    }

    @Test
    @DisplayName("Window slides past best section")
    void maxVowels_windowSlidesPastBest() {
        assertEquals(3, maximumNumberOfVowels.maxVowels("xxaeixxxx", 3));
    }


}