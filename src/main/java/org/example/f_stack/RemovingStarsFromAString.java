package org.example.f_stack;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * Removes stars from a string by deleting each star and the closest non-star
 * character to its left.
 *
 * <p>Solution 1 (Stack / LinkedList):
 * <ul>
 *   <li>Use a {@code LinkedList} as a stack with a last-in-first-out (LIFO) policy</li>
 *   <li>Append characters to the tail; on '*', remove from the tail</li>
 *   <li>Using the tail keeps the list in left-to-right order, so no reversal is needed</li>
 *   <li>Build the final string from the remaining list</li>
 * </ul>
 *
 * <p>Solution 2 (StringBuilder as a stack):
 * <ul>
 *   <li>Append letters to a {@code StringBuilder}</li>
 *   <li>On '*', delete the last character</li>
 *   <li>Return the builder as the result</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * s = "leet**cod*e"
 * stack progression:
 *   l e e t -> '*' pops t -> '*' pops e -> c o d -> '*' pops d -> e
 * result = "lecoe"
 * </pre>
 *
 * <p>Key insight: each star only affects the closest character to its left, so a stack
 * captures exactly which character should be removed.
 *
 * <p>Time Complexity:
 * O(n) for both solutions, where n is the length of the string.
 *
 * <p>Space Complexity:
 * O(n) for both solutions (stack or StringBuilder content).
 */
public class RemovingStarsFromAString {

    public String removeStars(String string) {
        char[] charArray = string.toCharArray();
        LinkedList<Character> charactersStacks = new LinkedList<>();
        for (char character : charArray) {
            if (character == '*') {
                charactersStacks.pollLast();
            } else {
                charactersStacks.add(character);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        charactersStacks.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }


    public String removeStarsUsingStringBuilder(String string) {
        StringBuilder ans = new StringBuilder();

        for (char character : string.toCharArray()) {
            if (character != '*') {
                ans.append(character);
            } else {
                ans.deleteCharAt(ans.length() - 1);
            }
        }

        return ans.toString();
    }
}
