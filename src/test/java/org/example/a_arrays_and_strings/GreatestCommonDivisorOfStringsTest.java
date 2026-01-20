package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GreatestCommonDivisorOfStringsTest {

    private GreatestCommonDivisorOfStrings sut;

    @BeforeEach
    void setUp() {
        sut = new GreatestCommonDivisorOfStrings();
    }

    @Test
    @DisplayName("Returns full string when both strings are exact multiples")
    void gcdOfStrings_exactMultiple() {
        assertEquals("ABC", sut.gcdOfStrings("ABCABC", "ABC"));
    }

    @Test
    @DisplayName("Returns partial divisor when strings share a smaller repeating pattern")
    void gcdOfStrings_partialDivisor() {
        assertEquals("AB", sut.gcdOfStrings("ABABAB", "ABAB"));
    }

    @Test
    @DisplayName("Returns empty string when no common divisor exists")
    void gcdOfStrings_noCommonDivisor() {
        assertEquals("", sut.gcdOfStrings("LEET", "CODE"));
    }

    @Test
    @DisplayName("Returns empty string when only one string is divisible")
    void gcdOfStrings_oneSideDivisibleOnly() {
        assertEquals("", sut.gcdOfStrings("AAAAAB", "AAA"));
    }

    @Test
    @DisplayName("Returns string itself when both strings are identical")
    void gcdOfStrings_identicalStrings() {
        assertEquals("ABC", sut.gcdOfStrings("ABC", "ABC"));
    }

    @Test
    @DisplayName("Handles single-character strings")
    void gcdOfStrings_singleCharacter() {
        assertEquals("A", sut.gcdOfStrings("AAAA", "A"));
    }

    @Test
    @DisplayName("Returns empty string when lengths match but pattern differs")
    void gcdOfStrings_sameLengthDifferentPattern() {
        assertEquals("", sut.gcdOfStrings("ABAB", "ABBA"));
    }
}
