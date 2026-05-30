package org.example.j_graph.task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 547. Number of Provinces
 *
 * <p><b>Approach:</b> Treat the adjacency matrix as a graph and count connected components
 * via DFS. For each unvisited city, start a DFS that marks all cities in the same province
 * as visited — each such DFS start is one province.
 *
 * <p>Example:
 * <pre>
 *   isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 *
 *   DFS from 0: marks 0, 1 visited   count=1
 *   DFS from 2: marks 2 visited      count=2
 *   result: 2
 * </pre>
 *
 * <p>Time Complexity: O(n²) — every cell of the matrix is visited once.
 *
 * <p>Space Complexity: O(n) — visited array and call stack each hold at most n entries.
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(j, isConnected, visited);
            }
        }
    }

}
