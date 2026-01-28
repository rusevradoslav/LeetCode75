package org.example.b_two_pointers;

/**
 * Determines if string s is a subsequence of string t.
 *
 * <p>A subsequence is formed by deleting some (or none) characters from the original
 * string without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde", while "aec" is not.
 *
 * <p>The algorithm uses a two-pointer approach:
 * <ul>
 *   <li>{@code firstStrIndex} tracks the current position in s (the subsequence)</li>
 *   <li>{@code secondStrIndex} scans through t (the source string)</li>
 *   <li>{@code matches} counts how many characters from s have been found in order</li>
 *   <li>When characters match, both pointers advance; otherwise only {@code secondStrIndex} advances</li>
 * </ul>
 *
 * <p>Example walkthrough for s="abc", t="ahbgdc":
 * <pre>
 *   firstStrIndex=0, secondStrIndex=0: s[0]='a' == t[0]='a', match!  → matches=1
 *   firstStrIndex=1, secondStrIndex=1: s[1]='b' != t[1]='h', skip
 *   firstStrIndex=1, secondStrIndex=2: s[1]='b' == t[2]='b', match!  → matches=2
 *   firstStrIndex=2, secondStrIndex=3: s[2]='c' != t[3]='g', skip
 *   firstStrIndex=2, secondStrIndex=4: s[2]='c' != t[4]='d', skip
 *   firstStrIndex=2, secondStrIndex=5: s[2]='c' == t[5]='c', match!  → matches=3
 *
 *   Result: matches(3) == s.length(3) → true
 * </pre>
 *
 * <p>Time Complexity:
 * O(n), where n is the length of t. Each character in t is visited at most once.
 *
 * <p>Space Complexity:
 * O(1), as only three integer variables are used.
 *
 * @param s the potential subsequence string
 * @param t the source string to check against
 * @return true if s is a subsequence of t, false otherwise
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int firstStrIndex = 0, secondStrIndex = 0, matches = 0;

        while (firstStrIndex < s.length() && secondStrIndex < t.length()) {
            if (s.charAt(firstStrIndex) == t.charAt(secondStrIndex)) {
                firstStrIndex++;
                matches++;
            }
            secondStrIndex++;
        }
        return matches == s.length();
    }
}
