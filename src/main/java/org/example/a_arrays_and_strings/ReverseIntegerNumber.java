package org.example.a_arrays_and_strings;

/**
 * Reverses the digits of an integer using arithmetic operations.
 *
 * <p>Example:
 * <pre>
 *  123   ->  321
 *  -120  ->  -21
 *  1999999999 -> 0 (overflow)
 * </pre>
 *
 * <p>Approach:
 * <ul>
 *   <li>Repeatedly extract the last digit using {@code number % 10}</li>
 *   <li>Append it to the result by multiplying result by 10 and adding the digit</li>
 *   <li>Remove the last digit from input using {@code number / 10}</li>
 * </ul>
 *
 * <p>Walkthrough with {@code 123}:
 * <pre>
 * Step 1: reversedNumber = 0 * 10 + 3 = 3,   number = 12
 * Step 2: reversedNumber = 3 * 10 + 2 = 32,  number = 1
 * Step 3: reversedNumber = 32 * 10 + 1 = 321, number = 0
 * </pre>
 *
 * <p>Overflow Handling:
 * Before multiplying by 10, we check if the result would exceed {@code int} range.
 * If {@code reversedNumber > Integer.MAX_VALUE / 10} or
 * {@code reversedNumber < Integer.MIN_VALUE / 10}, the next multiplication
 * would overflow, so we return 0.
 *
 * <p>Negative Numbers:
 * Java's {@code %} operator preserves the sign, so {@code -123 % 10 = -3}.
 * The algorithm works naturally without special handling.
 *
 * <p>Time Complexity: O(d), where d is the number of digits (approximately log₁₀(n)).
 *
 * <p>Space Complexity: O(1), only a single variable is used.
 */

public class ReverseIntegerNumber {

    public int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            if (willOverflow(reversedNumber)) {
                return 0;
            }
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }

    private static boolean willOverflow(int reversedNumber) {
        return reversedNumber > Integer.MAX_VALUE / 10 || reversedNumber < Integer.MIN_VALUE / 10;
    }
}
