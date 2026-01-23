package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseVowelsOfAStringTest {

    private ReverseVowelsOfAString reverseVowelsOfAString;

    @BeforeEach
    void setUp() {
        reverseVowelsOfAString = new ReverseVowelsOfAString();
    }

    @Test
    @DisplayName("Reverses vowels in a mixed-case string")
    void reverseVowels_mixedCase() {
        assertEquals("AceCreIm", reverseVowelsOfAString.reverseVowels("IceCreAm"));
    }

    @Test
    @DisplayName("String with only lowercase vowels")
    void reverseVowels_lowercaseVowelsOnly() {
        assertEquals("uoiea", reverseVowelsOfAString.reverseVowels("aeiou"));
    }

    @Test
    @DisplayName("String with no vowels remains unchanged")
    void reverseVowels_noVowels() {
        assertEquals("bcdfg", reverseVowelsOfAString.reverseVowels("bcdfg"));
    }

    @Test
    @DisplayName("Single character string")
    void reverseVowels_singleCharacter() {
        assertEquals("a", reverseVowelsOfAString.reverseVowels("a"));
    }

    @Test
    @DisplayName("Single vowel at start and end")
    void reverseVowels_startAndEndVowels() {
        assertEquals("obcda", reverseVowelsOfAString.reverseVowels("abcdo"));
    }

    @Test
    @DisplayName("Handles uppercase vowels correctly")
    void reverseVowels_uppercaseVowels() {
        assertEquals("UOIEA", reverseVowelsOfAString.reverseVowels("AEIOU"));
    }

    @Test
    @DisplayName("String with vowels and consonants interleaved")
    void reverseVowels_interleaved() {
        assertEquals("holle", reverseVowelsOfAString.reverseVowels("hello"));
    }

    @Test
    @DisplayName("String with no alphabetic characters")
    void reverseVowels_nonAlphabeticOnly() {
        assertEquals("12345", reverseVowelsOfAString.reverseVowels("12345"));
    }

    @Test
    @DisplayName("Empty string")
    void reverseVowels_emptyString() {
        assertEquals("", reverseVowelsOfAString.reverseVowels(""));
    }

    @Test
    @DisplayName("Handles string with one vowel followed by punctuation")
    void reverseVowels_singleVowelWithDot() {
        assertEquals("a.", reverseVowelsOfAString.reverseVowels("a."));
    }
}
