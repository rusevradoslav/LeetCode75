package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseIntegerNumberTest {

    private ReverseIntegerNumber reverseIntegerNumber;

    @BeforeEach
    void setUp() {
        reverseIntegerNumber = new ReverseIntegerNumber();
    }

    @Test
    @DisplayName("Reverses a typical positive number")
    void reverseNumber_positive() {
        assertEquals(321, reverseIntegerNumber.reverseNumber(123));
    }

    @Test
    @DisplayName("Reverses a negative number and keeps the sign")
    void reverseNumber_negative() {
        assertEquals(-321, reverseIntegerNumber.reverseNumber(-123));
    }

    @Test
    @DisplayName("Drops trailing zeros after reversing")
    void reverseNumber_trailingZeros() {
        assertEquals(21, reverseIntegerNumber.reverseNumber(1200));
    }

    @Test
    @DisplayName("Returns zero when input is zero")
    void reverseNumber_zero() {
        assertEquals(0, reverseIntegerNumber.reverseNumber(0));
    }

    @Test
    @DisplayName("Reverses a number ending with zero when negative")
    void reverseNumber_negativeTrailingZeros() {
        assertEquals(-21, reverseIntegerNumber.reverseNumber(-120));
    }
}
