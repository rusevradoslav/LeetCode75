package org.example.j_graph.traversal;

import org.example.j_graph.Edge;
import org.example.j_graph.Graph;
import org.example.j_graph.Vertex;

import java.util.*;

/**
 * Depth-first search (DFS) graph traversal — returns the DFS discovery forest:
 * a map from each reachable vertex (excluding the start) to the edge that first discovered it.
 *
 * <p><b>Approach:</b>
 * <ul>
 *   <li>Mark the current vertex visited</li>
 *   <li>For each outgoing edge, skip already-visited neighbours</li>
 *   <li>For each unvisited neighbour, record the discovery edge and recurse</li>
 * </ul>
 *
 * <p>Example:
 * <pre>
 *   Alice --- Bob --- Carol     Dan --- Eve
 *
 *   DFS from Alice: {Bob -> (Alice,Bob), Carol -> (Bob,Carol)}
 * </pre>
 *
 * <p>Time Complexity: O(V + E) — each vertex and edge visited at most once.
 *
 * <p>Space Complexity: O(V) — visited set and implicit call stack each hold at most V frames.
 *
 * @param <V> the type of vertex elements
 * @param <E> the type of edge elements
 */
public class DfsGraphTraversal<V, E> implements GraphTraversal<V, E> {

    /** {@inheritDoc} */
    @Override
    public Map<Vertex<V, E>, Edge<V, E>> traverse(Graph<V, E> graph, Vertex<V, E> start) {
        if (Objects.isNull(graph) || Objects.isNull(start)) {
            throw new IllegalArgumentException("Graph and start vertex must not be null");
        }
        Map<Vertex<V, E>, Edge<V, E>> forest = new HashMap<>();
        Set<Vertex<V, E>> visited = new HashSet<>();
        dfs(graph, start, visited, forest);
        return forest;
    }

    private void dfs(Graph<V, E> graph, Vertex<V, E> origin, Set<Vertex<V, E>> visited,
                     Map<Vertex<V, E>, Edge<V, E>> forest) {
        visited.add(origin);
        for (Edge<V, E> edge : graph.getOutgoingEdges(origin)) {
            Vertex<V, E> destination = graph.opposite(origin, edge);
            if (visited.contains(destination)) {
                continue;
            }
            forest.put(destination, edge);
            dfs(graph, destination, visited, forest);
        }
    }

    /**
     * Iterative depth-first search using an explicit stack — same discovery forest contract
     * as {@link #traverse} but avoids {@link StackOverflowError} on deep graphs.
     *
     * <p><b>Approach:</b>
     * <ul>
     *   <li>Push the start vertex onto a stack and mark it visited</li>
     *   <li>Pop a vertex, then for each unvisited neighbour: mark visited, record the
     *       discovery edge, and push onto the stack (LIFO keeps the traversal depth-first)</li>
     * </ul>
     *
     * <p>Example:
     * <pre>
     *   Alice --- Bob --- Carol     Dan --- Eve
     *
     *   iterative DFS from Alice: {Bob -> (Alice,Bob), Carol -> (Bob,Carol)}
     * </pre>
     *
     * <p>Time Complexity: O(V + E) — each vertex and edge visited at most once.
     *
     * <p>Space Complexity: O(V) — visited set and explicit stack each hold at most V entries.
     *
     * @param graph the graph to traverse; must not be {@code null}
     * @param start the vertex from which traversal begins; must not be {@code null}
     * @return a map from each discovered vertex to its discovery edge
     * @throws IllegalArgumentException if {@code graph} or {@code start} is {@code null}
     */
    public Map<Vertex<V, E>, Edge<V, E>> traverseIterative(Graph<V, E> graph, Vertex<V, E> start) {
        if (Objects.isNull(graph) || Objects.isNull(start)) {
            throw new IllegalArgumentException("Graph and start vertex must not be null");
        }
        Map<Vertex<V, E>, Edge<V, E>> forest = new HashMap<>();

        Set<Vertex<V, E>> visited = new HashSet<>();

        Deque<Vertex<V, E>> stack = new ArrayDeque<>();
        visited.add(start);
        stack.push(start);

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();
            for (Edge<V, E> edge : graph.getOutgoingEdges(vertex)) {
                Vertex<V, E> destination = graph.opposite(vertex, edge);
                if (visited.contains(destination)) {
                    continue;
                }
                visited.add(destination);
                stack.push(destination);
                forest.put(destination, edge);
            }
        }

        return forest;
    }
}
