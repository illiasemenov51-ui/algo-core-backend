package com.algocore.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionSorterTest {

    private final TransactionSorter sorter = new TransactionSorter();

    @Test
    void sortTransactions_returnsAscendingOrder() {
        int[] result = sorter.sortTransactions(new int[]{500, 100, 300});
        assertArrayEquals(new int[]{100, 300, 500}, result);
    }

    @Test
    void sortDescending_returnsDescendingOrder() {
        int[] result = sorter.sortDescending(new int[]{200, 50, 900});
        assertArrayEquals(new int[]{900, 200, 50}, result);
    }

    @Test
    void topN_returnsCorrectTopValues() {
        int[] result = sorter.topN(new int[]{10, 80, 30, 70, 50}, 3);
        assertArrayEquals(new int[]{80, 70, 50}, result);
    }

    @Test
    void sortTransactions_doesNotMutateOriginal() {
        int[] original = {3, 1, 2};
        sorter.sortTransactions(original);
        assertArrayEquals(new int[]{3, 1, 2}, original);
    }
}
