package org.example.j_graph.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KeysAndRoomsTest {

    private KeysAndRooms keysAndRooms;

    @BeforeEach
    void setUp() {
        keysAndRooms = new KeysAndRooms();
    }

    // --- all rooms reachable ---

    @Test
    @DisplayName("Linear chain: each room unlocks the next")
    void testLinearChain() {
        // 0 -> 1 -> 2 -> 3
        assertTrue(keysAndRooms.canVisitAllRooms(
                List.of(List.of(1), List.of(2), List.of(3), Collections.emptyList())));
    }

    @Test
    @DisplayName("Room reachable via indirect path, not only direct keys from room 0")
    void testIndirectPath() {
        // Room 0 has key 2; room 2 has key 1 — room 1 reachable transitively
        assertTrue(keysAndRooms.canVisitAllRooms(
                List.of(List.of(2), Collections.emptyList(), List.of(1))));
    }

    @Test
    @DisplayName("Room 0 holds all keys at once")
    void testAllKeysInRoom0() {
        assertTrue(keysAndRooms.canVisitAllRooms(
                List.of(List.of(1, 2, 3), Collections.emptyList(), Collections.emptyList(), Collections.emptyList())));
    }

    @Test
    @DisplayName("Duplicate keys in a room do not cause infinite loop")
    void testDuplicateKeys() {
        // Room 0 has key 1 twice; room 1 has key 2
        assertTrue(keysAndRooms.canVisitAllRooms(
                List.of(List.of(1, 1), List.of(2), Collections.emptyList())));
    }

    // --- not all rooms reachable ---

    @Test
    @DisplayName("Room with no incoming keys is unreachable")
    void testUnreachableRoom() {
        // Room 0 has key 2; room 1 is never unlocked
        assertFalse(keysAndRooms.canVisitAllRooms(
                List.of(List.of(2), Collections.emptyList(), Collections.emptyList())));
    }

    @Test
    @DisplayName("Cycle between locked rooms does not help reach them")
    void testLockedCycle() {
        // Rooms 1 and 2 hold each other's keys but neither is reachable from room 0
        assertFalse(keysAndRooms.canVisitAllRooms(
                List.of(Collections.emptyList(), List.of(2), List.of(1))));
    }

    // --- edge cases ---

    @Test
    @DisplayName("Single room with no keys is always visitable")
    void testSingleRoom() {
        assertTrue(keysAndRooms.canVisitAllRooms(
                List.of(Collections.emptyList())));
    }

    @Test
    @DisplayName("Room 0 key pointing back to itself does not cause a problem")
    void testSelfLoop() {
        assertTrue(keysAndRooms.canVisitAllRooms(
                List.of(List.of(0, 1), Collections.emptyList())));
    }
}
