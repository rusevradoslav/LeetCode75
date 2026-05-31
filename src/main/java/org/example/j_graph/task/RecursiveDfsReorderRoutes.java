package org.example.j_graph.task;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 1466 — Reorder Routes to Make All Paths Lead to the City Zero.
 * Recursive DFS implementation.
 *
 * <p><b>Approach:</b>
 * <ul>
 *   <li>Build an adjacency list treating the tree as undirected: each original edge
 *       (a → b) is stored as {@code Node(b, true)} at index a, and as {@code Node(a, false)}
 *       at index b.</li>
 *   <li>Run DFS from city 0, recursively visiting every unvisited neighbor.</li>
 *   <li>Every original edge encountered during DFS points away from city 0 and must be
 *       reversed — increment the counter for each such edge.</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 *   connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 *
 *   Undirected view (original / reversed):
 *     0 —(orig)→ 1 —(orig)→ 3 ←(orig)— 2
 *     0 ←(orig)— 4 —(orig)→ 5
 *
 *   DFS from 0:
 *     visit 1  (via orig  0→1)  counter=1
 *     visit 3  (via orig  1→3)  counter=2
 *     visit 2  (via rev   3→2)  counter=2
 *     visit 4  (via rev   0←4)  counter=2
 *     visit 5  (via orig  4→5)  counter=3
 *   result: 3
 * </pre>
 *
 * <p>Time Complexity: O(n) — each city and edge visited once.
 *
 * <p>Space Complexity: O(n) — adjacency list, visited array, and call stack each hold
 * at most n entries. Risks stack overflow for degenerate chain inputs up to n=50 000.
 */
public class RecursiveDfsReorderRoutes implements ReorderRoutes {

    private record Node(int v, boolean isOrdinal) {}

    @Override
    public int minReorder(int n, int[][] connections) {
        List<List<Node>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            adjacencyList.get(from).add(new Node(to, true));
            adjacencyList.get(to).add(new Node(from, false));
        }

        boolean[] visited = new boolean[n];
        return dfs(0, visited, adjacencyList);
    }

    private int dfs(int node, boolean[] visited, List<List<Node>> adjacencyList) {
        int counter = 0;
        visited[node] = true;
        for (Node neighbour : adjacencyList.get(node)) {
            if (visited[neighbour.v()]) {
                continue;
            }
            if (neighbour.isOrdinal()) {
                counter++;
            }
            counter += dfs(neighbour.v(), visited, adjacencyList);
        }
        return counter;
    }
}
