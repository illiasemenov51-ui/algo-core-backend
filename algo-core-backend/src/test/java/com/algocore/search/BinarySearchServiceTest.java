package com.algocore.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchServiceTest {

    private final BinarySearchService service = new BinarySearchService();

    @Test
    void search_targetFound_returnsCorrectIndex() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(3, service.search(arr, 7));
    }

    @Test
    void search_targetNotFound_returnsMinusOne() {
        int[] arr = {2, 4, 6, 8};
        assertEquals(-1, service.search(arr, 5));
    }

    @Test
    void search_singleElement_found() {
        assertEquals(0, service.search(new int[]{42}, 42));
    }

    @Test
    void searchFirst_duplicates_returnsFirstIndex() {
        int[] arr = {1, 2, 2, 2, 3};
        assertEquals(1, service.searchFirst(arr, 2));
    }
}
