package org.example.a_arrays_and_strings;

/**
 * Finds the greatest common divisor (GCD) string of two input strings.
 *
 * <p>A string x is said to divide a string y if y can be formed by
 * concatenating x one or more times. This method returns the largest
 * possible string that divides both input strings.
 *
 * <p>Time Complexity:
 * O(n + m), where n is the length of str1 and m is the length of str2.
 * The dominant operation is string concatenation and comparison
 * (str1 + str2).equals(str2 + str1).
 *
 * <p>Space Complexity:
 * O(n + m), due to the creation of intermediate concatenated strings
 * and the resulting substring.
 *
 * <p>Approach:
 * <ul>
 *   <li>First, verify both strings share the same repeating pattern by
 *       comparing their concatenations.</li>
 *   <li>Compute the GCD of the two string lengths using the Euclidean algorithm.</li>
 *   <li>Return the prefix of length GCD as the result.</li>
 * </ul>
 *
 * <p>Euclidean Algorithm:
 * The Euclidean algorithm computes the greatest common divisor of two
 * integers by repeatedly replacing the larger number with the remainder
 * of dividing it by the smaller number. This process continues until
 * the remainder becomes zero. The last non-zero value is the GCD.
 *
 * <p>This algorithm runs in O(log(min(n, m))) time and guarantees that
 * the largest possible divisor length is selected.
 */

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}