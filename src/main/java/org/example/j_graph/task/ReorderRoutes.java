package org.example.j_graph.task;

public interface ReorderRoutes {

    /**
     * Returns the minimum number of edges that must be reversed so that every city
     * can reach city 0.
     *
     * @param n           total number of cities (0-indexed)
     * @param connections directed edges as {@code [from, to]} pairs forming a tree
     * @return minimum number of reversals required
     */
    int minReorder(int n, int[][] connections);
}
