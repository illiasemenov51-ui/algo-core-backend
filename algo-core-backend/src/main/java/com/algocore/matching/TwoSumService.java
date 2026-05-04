package com.algocore.matching;

import java.util.HashMap;
import java.util.Map;

/**
 * Matching service using the Two Sum algorithm.
 * Real-world analogy: finding complementary orders in a trading system
 * or pairing items that together reach a target budget.
 */
public class TwoSumService {

    /**
     * Find indices of the two numbers that add up to the target.
     *
     * @param nums   input array
     * @param target desired sum
     * @return int array of two indices, or {-1, -1} if no pair found
     * Time Complexity: O(n) | Space Complexity: O(n)
     */
    public int[] findPair(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    /**
     * Check whether any two numbers in the array sum to the target.
     *
     * @param nums   input array
     * @param target desired sum
     * @return true if a valid pair exists
     */
    public boolean hasPair(int[] nums, int target) {
        int[] result = findPair(nums, target);
        return result[0] != -1;
    }
}
