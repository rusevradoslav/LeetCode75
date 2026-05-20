package org.example.j_graph.task;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 841. Keys and Rooms
 *
 * <p><b>Approach:</b> DFS from room 0 using the input as an adjacency list directly.
 * Track visited room numbers in a {@link HashSet}. After traversal, compare visited
 * count to total room count.
 *
 * <p>Example:
 * <pre>
 *   rooms = [[1], [2], [3], []]
 *
 *   DFS: 0 -> 1 -> 2 -> 3   visited={0,1,2,3}   4 == 4  -> true
 * </pre>
 *
 * <p>Time Complexity: O(V + E) — each room visited once, each key processed once.
 *
 * <p>Space Complexity: O(V) — visited set and call stack each hold at most V entries.
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        visitRooms(rooms, 0, visitedRooms);
        return visitedRooms.size() == rooms.size();
    }

    private void visitRooms(List<List<Integer>> rooms, Integer key, Set<Integer> visitedRooms) {
        if (visitedRooms.contains(key)) {
            return;
        }
        visitedRooms.add(key);
        rooms.get(key).forEach(room -> visitRooms(rooms, room, visitedRooms));
    }
}
