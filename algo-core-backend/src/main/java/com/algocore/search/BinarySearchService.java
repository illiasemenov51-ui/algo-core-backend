package com.algocore.search;

/**
 * Binary search implementation representing fast lookups in sorted datasets.
 * In real systems this mirrors indexed column lookups in relational databases.
 */
public class BinarySearchService {

    /**
     * Search for a target value in a sorted integer array.
     *
     * @param arr    sorted integer array
     * @param target value to find
     * @return index of target, or -1 if not found
     * Time Complexity: O(log n) | Space Complexity: O(1)
     */
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    /**
     * Find the first occurrence of target in a sorted array with duplicates.
     *
     * @param arr    sorted array (may contain duplicates)
     * @param target value to find
     * @return index of first occurrence, or -1 if not found
     */
    public int searchFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // keep searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
