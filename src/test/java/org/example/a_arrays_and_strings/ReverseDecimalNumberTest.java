package org.example.a_arrays_and_strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseDecimalNumberTest {

    private static final double EPS = 1e-9;

    private ReverseDecimalNumber reverseDecimalNumber;

    @BeforeEach
    void setUp() {
        reverseDecimalNumber = new ReverseDecimalNumber();
    }

    @Test
    @DisplayName("Reverses digits for a typical positive number")
    void reverseDecimal_positiveTypical() {
        assertEquals(8765.4321, reverseDecimalNumber.reverseDecimal(1234.5678), EPS);
    }

    @Test
    @DisplayName("Reverses digits for a typical negative number and preserves sign")
    void reverseDecimal_negativeTypical() {
        assertEquals(-225.14321, reverseDecimalNumber.reverseDecimal(-12341.522), EPS);
    }

    @Test
    @DisplayName("Works when integer part ends with zero after reversing (keeps leading zeros in fractional result numerically)")
    void reverseDecimal_requiresLeadingZeroInFraction() {
        assertEquals(225.01, reverseDecimalNumber.reverseDecimal(10.522), EPS);
    }

    @Test
    @DisplayName("Works when fractional part contains trailing zeros in the literal input (best-effort with double)")
    void reverseDecimal_fractionHasTrailingZeros_bestEffort() {

        assertEquals(43.21, reverseDecimalNumber.reverseDecimal(12.34), EPS);
    }

    @Test
    @DisplayName("Handles very small positive fractional values (may be affected by scientific notation)")
    void reverseDecimal_smallValue_bestEffort() {
        assertEquals(0.1, reverseDecimalNumber.reverseDecimal(1.0), EPS);
    }

    @Test
    @DisplayName("Handles single-digit integer and single-digit fraction")
    void reverseDecimal_singleDigitParts() {
        assertEquals(2.1, reverseDecimalNumber.reverseDecimal(1.2), EPS);
    }

    @Test
    @DisplayName("Handles multi-digit integer with short fraction")
    void reverseDecimal_multiDigitIntegerShortFraction() {
        assertEquals(3.21, reverseDecimalNumber.reverseDecimal(12.3), EPS);
    }

    @Test
    @DisplayName("Handles negative number with short fraction")
    void reverseDecimal_negativeShortFraction() {
        assertEquals(-3.21, reverseDecimalNumber.reverseDecimal(-12.3), EPS);
    }
}
