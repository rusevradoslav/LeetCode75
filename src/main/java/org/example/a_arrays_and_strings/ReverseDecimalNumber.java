package org.example.a_arrays_and_strings;


/**
 * Reverses a decimal number by reversing the digits of the integer part and the fractional part,
 * then swapping them around the decimal point.
 *
 * <p>Example:
 * <pre>
 *  1234.5678  ->  8765.4321
 *  -12341.522 ->  -225.14321
 * </pre>
 *
 * <p>Approach:
 * <ul>
 *   <li>Convert the absolute value of the input to a textual decimal representation and split it by '.'</li>
 *   <li>Let the integer part be {@code A} and fractional part be {@code B}</li>
 *   <li>Reverse {@code B} to become the new integer part</li>
 *   <li>Reverse {@code A} and scale it by {@code 10^(len(A))} to become the new fractional part</li>
 *   <li>Reapply the original sign</li>
 * </ul>
 *
 * <p>Time Complexity:
 * O(d), where d is the total number of digits in the integer and fractional parts.
 * The algorithm reverses each part once and performs constant-time arithmetic per digit.
 *
 * <p>Space Complexity:
 * O(d) due to intermediate string creation when splitting the input and parsing.
 *
 * <p>Notes:
 * <ul>
 *   <li>This method depends on {@code String.valueOf(double)} formatting, which may use scientific notation
 *       for very small/large values and may expose floating-point representation artifacts.</li>
 *   <li>Trailing zeros in the fractional portion may not be preserved by {@code double} string conversion.</li>
 * </ul>
 *
 * @param number the input decimal number
 * @return the digit-reversed decimal number with the same sign as the input
 */


public class ReverseDecimalNumber {

    public double reverseDecimal(double number) {
        String[] parts = String.valueOf(Math.abs(number)).split("\\.");
        int fraction = parts[0].length();
        long fPart = Math.abs(Long.parseLong(parts[0]));
        long sPart = Long.parseLong(parts[1]);
        int multiplier = number < 0 ? -1 : 1;

        double fPartReversed = reverse(sPart);
        double sPartReversed = reverse(fPart) / Math.pow(10, fraction);


        return (fPartReversed + sPartReversed) * multiplier;
    }

    private static double reverse(long number) {
        double reversedNumber = 0;
        while (number != 0) {
            long lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }
        return reversedNumber;
    }
}
