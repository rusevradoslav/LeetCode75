package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCompressionTest {

    private StringCompression stringCompression;

    @BeforeEach
    void setUp() {
        stringCompression = new StringCompression();
    }

    @Test
    @DisplayName("Example 1: compresses repeated groups and returns new length")
    void compress_example1() {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int len = stringCompression.compress(input);

        assertEquals(6, len);
        assertArrayEquals(new char[]{'a', '2', 'b', '2', 'c', '3'}, slice(input, len));
    }

    @Test
    @DisplayName("Example 2: single character stays unchanged")
    void compress_singleCharacter() {
        char[] input = {'a'};

        int len = stringCompression.compress(input);

        assertEquals(1, len);
        assertArrayEquals(new char[]{'a'}, slice(input, len));
    }

    @Test
    @DisplayName("Example 3: group length >= 10 is written as multiple digits")
    void compress_countTenOrMore() {
        char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        int len = stringCompression.compress(input);

        assertEquals(4, len);
        assertArrayEquals(new char[]{'a', 'b', '1', '2'}, slice(input, len));
    }

    @Test
    @DisplayName("All unique characters: length unchanged and content same")
    void compress_allUnique() {
        char[] input = {'a', 'b', 'c', 'd'};

        int len = stringCompression.compress(input);

        assertEquals(4, len);
        assertArrayEquals(new char[]{'a', 'b', 'c', 'd'}, slice(input, len));
    }

    @Test
    @DisplayName("All same characters: writes char and count")
    void compress_allSame() {
        char[] input = {'z', 'z', 'z', 'z', 'z'};

        int len = stringCompression.compress(input);

        assertEquals(2, len);
        assertArrayEquals(new char[]{'z', '5'}, slice(input, len));
    }

    @Test
    @DisplayName("Two-digit count: 10 a's -> 'a10'")
    void compress_exactlyTen() {
        char[] input = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};

        int len = stringCompression.compress(input);

        assertEquals(3, len);
        assertArrayEquals(new char[]{'a', '1', '0'}, slice(input, len));
    }

    @Test
    @DisplayName("Mixed groups: writes counts only when group size > 1")
    void compress_mixedGroups() {
        char[] input = {'a', 'a', 'c', 'c', 'c', 'c', 'b'};

        int len = stringCompression.compress(input);

        assertEquals(5, len);
        assertArrayEquals(new char[]{'a', '2', 'c', '4', 'b'}, slice(input, len));
    }

    @Test
    @DisplayName("Ends with repeated group: last group is handled correctly")
    void compress_lastGroupRepeated() {
        char[] input = {'a', 'b', 'b', 'b'};

        int len = stringCompression.compress(input);

        assertEquals(3, len);
        assertArrayEquals(new char[]{'a', 'b', '3'}, slice(input, len));
    }

    @Test
    @DisplayName("Alternating pairs: many small groups")
    void compress_manySmallGroups() {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c'};

        int len = stringCompression.compress(input);

        assertEquals(6, len);
        assertArrayEquals(new char[]{'a', '2', 'b', '2', 'c', '2'}, slice(input, len));
    }

    private static char[] slice(char[] array, int len) {
        char[] out = new char[len];
        System.arraycopy(array, 0, out, 0, len);
        return out;
    }
}
