package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseWordsInAStringTest {

    private ReverseWordsInAString reverseWordsInAString;

    @BeforeEach
    void setUp() {
        reverseWordsInAString = new ReverseWordsInAString();
    }

    @Test
    @DisplayName("Reverses words in a normal sentence")
    void reverseWords_basicExample() {
        assertEquals("blue is sky the", reverseWordsInAString.reverseWords("the sky is blue"));
    }

    @Test
    @DisplayName("Removes leading and trailing spaces")
    void reverseWords_leadingAndTrailingSpaces() {
        assertEquals("world hello", reverseWordsInAString.reverseWords("  hello world  "));
    }

    @Test
    @DisplayName("Reduces multiple spaces between words to a single space")
    void reverseWords_multipleSpacesBetweenWords() {
        assertEquals("example good a", reverseWordsInAString.reverseWords("a   good   example"));
    }

    @Test
    @DisplayName("Handles single word input")
    void reverseWords_singleWord() {
        assertEquals("hello", reverseWordsInAString.reverseWords("hello"));
    }

    @Test
    @DisplayName("Handles empty string")
    void reverseWords_emptyString() {
        assertEquals("", reverseWordsInAString.reverseWords(""));
    }

    @Test
    @DisplayName("Handles input with only spaces")
    void reverseWords_onlySpaces() {
        assertEquals("", reverseWordsInAString.reverseWords("     "));
    }

    @Test
    @DisplayName("Handles words separated by tabs")
    void reverseWords_tabsBetweenWords() {
        assertEquals("world hello", reverseWordsInAString.reverseWords("hello\tworld"));
    }
}
