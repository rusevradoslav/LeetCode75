package org.example.j_graph.traversal;

import org.example.j_graph.Edge;
import org.example.j_graph.Graph;
import org.example.j_graph.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DfsGraphTraversalTest extends GraphTraversalTest {

    // Undirected fixture graph:
    //
    //   Alice --- Bob --- Carol     Dan --- Eve

    private DfsGraphTraversal<String, String> dfs;
    private Graph<String, String> graph;
    private Vertex<String, String> alice;
    private Vertex<String, String> bob;
    private Vertex<String, String> carol;
    private Vertex<String, String> dan;
    private Vertex<String, String> eve;
    private Edge<String, String> edgeAB;
    private Edge<String, String> edgeBC;

    @Override
    GraphTraversal<String, String> createTraversal() {
        return new DfsGraphTraversal<>();
    }

    @BeforeEach
    public void setUpIterative() {
        dfs = new DfsGraphTraversal<>();
        graph = new Graph<>(false);
        alice = graph.insertVertex("Alice");
        bob = graph.insertVertex("Bob");
        carol = graph.insertVertex("Carol");
        dan = graph.insertVertex("Dan");
        eve = graph.insertVertex("Eve");
        edgeAB = graph.insertEdge(alice, bob, "AB");
        edgeBC = graph.insertEdge(bob, carol, "BC");
        graph.insertEdge(dan, eve, "DE");
    }

    // --- traverseIterative ---

    @Test
    @DisplayName("Iterative: from Alice result map has exactly 2 entries")
    public void testIterativeFromAliceMapSize() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Iterative: from Alice Bob is present")
    public void testIterativeFromAliceBobPresent() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertTrue(result.containsKey(bob));
    }

    @Test
    @DisplayName("Iterative: from Alice Carol is present")
    public void testIterativeFromAliceCarolPresent() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertTrue(result.containsKey(carol));
    }

    @Test
    @DisplayName("Iterative: from Alice Dan is absent (different component)")
    public void testIterativeFromAliceDanAbsent() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertFalse(result.containsKey(dan));
    }

    @Test
    @DisplayName("Iterative: from Alice Eve is absent (different component)")
    public void testIterativeFromAliceEveAbsent() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertFalse(result.containsKey(eve));
    }

    @Test
    @DisplayName("Iterative: start vertex Alice is NOT in result map")
    public void testIterativeStartNotInResult() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertFalse(result.containsKey(alice));
    }

    @Test
    @DisplayName("Iterative: Bob's discovery edge is the (Alice,Bob) edge instance")
    public void testIterativeBobDiscoveryEdge() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertSame(edgeAB, result.get(bob));
    }

    @Test
    @DisplayName("Iterative: Carol's discovery edge is the (Bob,Carol) edge instance")
    public void testIterativeCarolDiscoveryEdge() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, alice);
        assertSame(edgeBC, result.get(carol));
    }

    @Test
    @DisplayName("Iterative: from Dan result map has exactly 1 entry")
    public void testIterativeFromDanMapSize() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, dan);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Iterative: from Dan Eve is present")
    public void testIterativeFromDanEvePresent() {
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(graph, dan);
        assertTrue(result.containsKey(eve));
    }

    @Test
    @DisplayName("Iterative: single-vertex graph returns empty map")
    public void testIterativeSingleVertex() {
        Graph<String, String> single = new Graph<>(false);
        Vertex<String, String> solo = single.insertVertex("Solo");
        assertTrue(dfs.traverseIterative(single, solo).isEmpty());
    }

    @Test
    @DisplayName("Iterative: directed graph with cycle terminates without infinite loop")
    public void testIterativeDirectedCycleTerminates() {
        Graph<String, String> cyclic = new Graph<>(true);
        Vertex<String, String> u = cyclic.insertVertex("U");
        Vertex<String, String> v = cyclic.insertVertex("V");
        Vertex<String, String> w = cyclic.insertVertex("W");
        cyclic.insertEdge(u, v, "UV");
        cyclic.insertEdge(v, w, "VW");
        cyclic.insertEdge(w, u, "WU");
        Map<Vertex<String, String>, Edge<String, String>> result = dfs.traverseIterative(cyclic, u);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(v));
        assertTrue(result.containsKey(w));
    }
}
