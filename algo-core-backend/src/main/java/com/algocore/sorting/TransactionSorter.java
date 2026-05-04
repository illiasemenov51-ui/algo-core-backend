package com.algocore.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sorting service for financial transactions.
 * Mirrors ledger ordering in payment processing systems.
 */
public class TransactionSorter {

    /**
     * Sort transactions by amount in ascending order.
     *
     * @param transactions array of transaction amounts
     * @return sorted copy of the array
     * Time Complexity: O(n log n) | Space Complexity: O(n)
     */
    public int[] sortTransactions(int[] transactions) {
        int[] copy = Arrays.copyOf(transactions, transactions.length);
        Arrays.sort(copy);
        return copy;
    }

    /**
     * Sort transactions by amount in descending order.
     *
     * @param transactions array of transaction amounts
     * @return sorted copy in descending order
     */
    public int[] sortDescending(int[] transactions) {
        return Arrays.stream(transactions)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * Find the top N largest transactions.
     *
     * @param transactions array of transaction amounts
     * @param n            number of top transactions to return
     * @return array of top N values in descending order
     */
    public int[] topN(int[] transactions, int n) {
        int[] sorted = sortDescending(transactions);
        return Arrays.copyOf(sorted, Math.min(n, sorted.length));
    }
}
