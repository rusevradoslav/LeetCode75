package org.example.b_two_pointers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IsSubsequenceTest {

    private IsSubsequence isSubsequence;

    @BeforeEach
    void setUp() {
        isSubsequence = new IsSubsequence();
    }

    @Test
    @DisplayName("Example 1: 'abc' is a subsequence of 'ahbgdc'")
    void isSubsequence_example1() {
        assertTrue(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    @DisplayName("Example 2: 'axc' is not a subsequence of 'ahbgdc'")
    void isSubsequence_example2() {
        assertFalse(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }

    @Test
    @DisplayName("Empty s is a subsequence of any string")
    void isSubsequence_emptyS() {
        assertTrue(isSubsequence.isSubsequence("", "ahbgdc"));
    }

    @Test
    @DisplayName("Empty s is a subsequence of empty t")
    void isSubsequence_bothEmpty() {
        assertTrue(isSubsequence.isSubsequence("", ""));
    }

    @Test
    @DisplayName("Non-empty s is not a subsequence of empty t")
    void isSubsequence_emptyT() {
        assertFalse(isSubsequence.isSubsequence("abc", ""));
    }

    @Test
    @DisplayName("s equals t: s is a subsequence")
    void isSubsequence_sEqualsT() {
        assertTrue(isSubsequence.isSubsequence("abc", "abc"));
    }

    @Test
    @DisplayName("s longer than t: not a subsequence")
    void isSubsequence_sLongerThanT() {
        assertFalse(isSubsequence.isSubsequence("abcdef", "abc"));
    }

    @Test
    @DisplayName("Single character match")
    void isSubsequence_singleCharMatch() {
        assertTrue(isSubsequence.isSubsequence("a", "a"));
    }

    @Test
    @DisplayName("Single character no match")
    void isSubsequence_singleCharNoMatch() {
        assertFalse(isSubsequence.isSubsequence("a", "b"));
    }

    @Test
    @DisplayName("Characters in wrong order: not a subsequence")
    void isSubsequence_wrongOrder() {
        assertFalse(isSubsequence.isSubsequence("aec", "abcde"));
    }

    @Test
    @DisplayName("Subsequence with repeated characters in t")
    void isSubsequence_repeatedCharsInT() {
        assertTrue(isSubsequence.isSubsequence("aaa", "aaaaaa"));
    }

    @Test
    @DisplayName("Subsequence at the very end of t")
    void isSubsequence_atEndOfT() {
        assertTrue(isSubsequence.isSubsequence("xyz", "abcxyz"));
    }

    @Test
    @DisplayName("Subsequence at the very beginning of t")
    void isSubsequence_atBeginningOfT() {
        assertTrue(isSubsequence.isSubsequence("abc", "abcxyz"));
    }

    @Test
    @DisplayName("Subsequence with gaps in t")
    void isSubsequence_withGaps() {
        assertTrue(isSubsequence.isSubsequence("ace", "abcde"));
    }

    @Test
    @DisplayName("Last character of s not found in t")
    void isSubsequence_lastCharMissing() {
        assertFalse(isSubsequence.isSubsequence("abcd", "abc"));
    }

    @Test
    @DisplayName("Last character of s not found in t")
    void test() {
        assertFalse(isSubsequence.isSubsequence("aaaaaa", "bbaaaa"));
    }
}
