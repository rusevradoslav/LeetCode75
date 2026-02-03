package org.example.e_hash_map_set;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Counts how many row/column pairs in a square grid are identical.
 *
 * <p>A pair (r, c) is equal when the entire row {@code r} matches the entire
 * column {@code c}. The algorithm counts each row signature in a map, then builds
 * each column signature and sums its row frequency.
 *
 * <p>The algorithm uses a HashMap approach:
 * <ul>
 *   <li>Convert each row to a {@code List<Integer>} key and count its frequency</li>
 *   <li>Build each column as a list and add the stored frequency to the answer</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 * grid =
 * [
 *   [3, 2, 1],
 *   [1, 7, 6],
 *   [2, 7, 7]
 * ]
 *
 * Row keys:
 *   [3, 2, 1] → 1
 *   [1, 7, 6] → 1
 *   [2, 7, 7] → 1
 *
 * Column keys:
 *   col 0 = [3, 1, 2] → 0 matches
 *   col 1 = [2, 7, 7] → 1 match
 *   col 2 = [1, 6, 7] → 0 matches
 *
 * Result: 1
 * </pre>
 *
 * <p>Key insight: A column can match multiple identical rows, so storing row
 * frequencies lets each column contribute the correct count in O(1) lookup time.
 *
 * <p>Time Complexity:
 * O(n^2) where n is the grid size. Building row and column keys touches every cell.
 *
 * <p>Space Complexity:
 * O(n^2) for storing n row keys of length n in the map.
 */
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> numbers = new HashMap<>();

        for (int[] row : grid) {
            List<Integer> rowNumbers = Arrays.stream(row).boxed().toList();
            if (numbers.containsKey(rowNumbers)) {
                numbers.put(rowNumbers, numbers.get(rowNumbers) + 1);
            } else {
                numbers.put(rowNumbers, 1);
            }
        }



        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] column = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                column[j] = grid[j][i];
            }
            List<Integer> columnNumbers = Arrays.stream(column).boxed().toList();
            if (numbers.containsKey(columnNumbers)) {
                result += numbers.get(columnNumbers);
            }
        }

        return result;
    }
}
