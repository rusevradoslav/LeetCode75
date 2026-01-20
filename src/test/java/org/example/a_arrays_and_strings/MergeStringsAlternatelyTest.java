package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeStringsAlternatelyTest {

    private MergeStringsAlternately mergeStringsAlternately;

    @BeforeEach
    void setUp() {
        mergeStringsAlternately = new MergeStringsAlternately();
    }

    @Test
    @DisplayName("Merges two strings of equal length alternately")
    void mergeAlternately_equalLength() {
        assertEquals("apbqcr", mergeStringsAlternately.mergeAlternately("abc", "pqr"));
    }

    @Test
    @DisplayName("Appends remaining characters when second string is longer")
    void mergeAlternately_secondStringLonger() {
        assertEquals("apbqrs", mergeStringsAlternately.mergeAlternately("ab", "pqrs"));
    }

    @Test
    @DisplayName("Appends remaining characters when first string is longer")
    void mergeAlternately_firstStringLonger() {
        assertEquals("apbqcd", mergeStringsAlternately.mergeAlternately("abcd", "pq"));
    }
}
