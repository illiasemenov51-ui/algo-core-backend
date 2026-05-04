package com.algocore.matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumServiceTest {

    private final TwoSumService service = new TwoSumService();

    @Test
    void findPair_validPairExists_returnsIndices() {
        int[] result = service.findPair(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void findPair_noPairExists_returnsMinusOne() {
        int[] result = service.findPair(new int[]{1, 2, 3}, 100);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    void hasPair_returnsTrueWhenPairExists() {
        assertTrue(service.hasPair(new int[]{3, 5, 8}, 13));
    }

    @Test
    void hasPair_returnsFalseWhenNoPair() {
        assertFalse(service.hasPair(new int[]{1, 2, 3}, 50));
    }
}
