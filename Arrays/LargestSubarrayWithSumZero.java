// Problem: Largest Subarray with Sum 0
//
// Description:
// Given an integer array that may contain positive, negative,
// or zero values, find the length of the longest subarray
// whose sum is exactly 0.
//
// Approach:
// - Use Prefix Sum + HashMap.
// - If the same prefix sum occurs again, the elements between
//   the two indices have sum 0.
// - Store the first occurrence of each prefix sum to maximize length.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;

public class LargestSubarrayWithSumZero {

    public static int largestSubarraySumZero(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: Subarray from index 0 to i
            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            // Case 2: Subarray exists between two same prefix sums
            if (map.containsKey(prefixSum)) {
                int len = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, len);
            } else {
                // Store first occurrence only
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of largest subarray with sum 0: "
                + largestSubarraySumZero(arr));
    }
}
