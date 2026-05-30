package org.example.j_graph.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfProvincesTest {

    private NumberOfProvinces numberOfProvinces;

    @BeforeEach
    void setUp() {
        numberOfProvinces = new NumberOfProvinces();
    }

    @Test
    @DisplayName("Single city is one province")
    void testSingleCity() {
        assertEquals(1, numberOfProvinces.findCircleNum(new int[][]{{1}}));
    }

    @Test
    @DisplayName("All cities directly connected form one province")
    void testAllCitiesConnected() {
        assertEquals(1, numberOfProvinces.findCircleNum(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }));
    }

    @Test
    @DisplayName("No cities share a connection — each is its own province")
    void testNoCitiesConnected() {
        assertEquals(3, numberOfProvinces.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        }));
    }

    @Test
    @DisplayName("Two cities connected, one isolated — two provinces")
    void testTwoCitiesConnectedOneIsolated() {
        assertEquals(2, numberOfProvinces.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }

    @Test
    @DisplayName("Two separate pairs of cities — two provinces")
    void testTwoPairs() {
        assertEquals(2, numberOfProvinces.findCircleNum(new int[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        }));
    }

    @Test
    @DisplayName("Cities connected in a chain form one province")
    void testChainConnection() {
        assertEquals(1, numberOfProvinces.findCircleNum(new int[][]{
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        }));
    }

    @Test
    @DisplayName("Two cities directly connected form one province")
    void testTwoCitiesConnected() {
        assertEquals(1, numberOfProvinces.findCircleNum(new int[][]{
                {1, 1},
                {1, 1}
        }));
    }

    @Test
    @DisplayName("Two cities not connected are two provinces")
    void testTwoCitiesNotConnected() {
        assertEquals(2, numberOfProvinces.findCircleNum(new int[][]{
                {1, 0},
                {0, 1}
        }));
    }
}
