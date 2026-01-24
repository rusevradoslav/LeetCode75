package org.example.a_arrays_and_strings;

/**
 * Reverses the digits of an integer using arithmetic operations.
 *
 * <p>Example:
 * <pre>
 *  123   ->  321
 *  -120  ->  -21
 * </pre>
 *
 * <p>Approach:
 * Repeatedly take the last digit using {@code number % 10} and append it to the result.
 *
 * <p>Time Complexity: O(d), where d is the number of digits in {@code number}.
 * <p>Space Complexity: O(1).
 *
 * <p>Note:
 * This implementation does not check for integer overflow. If the reversed value
 * exceeds {@code int} range, the result will overflow.
 */

public class ReverseIntegerNumber {

    public int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number = number / 10;
        }
        return reversedNumber;
    }
}
