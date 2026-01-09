// Problem: Longest Subarray with Sum K (including negative numbers)
// Description:
// Given an array of integers (which may include negative numbers) and an integer K,
// find the length of the longest subarray whose sum is exactly equal to K.
//

// Approach:
// - Use Prefix Sum + HashMap.
// - Maintain a running prefix sum while traversing the array.
// - If (prefixSum - K) exists in the map, then a subarray with sum K exists
//   between the stored index + 1 and the current index.
// - Store the first occurrence of each prefix sum to maximize subarray length.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    public static int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: Subarray from index 0 to i
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // Case 2: Subarray exists between indices
            if (map.containsKey(prefixSum - k)) {
                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store prefix sum only if it is not already present
            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {1, -1, 5, -2, 3};
        int k = 3;

        int result = longestSubarray(arr, k);
        System.out.println("Longest subarray length: " + result);
    }
}
