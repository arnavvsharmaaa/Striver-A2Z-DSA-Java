// Problem: Count Subarrays with Given Sum K
//
// Description:
// Given an array of integers (which may include negative numbers) and an integer K,
// count the total number of subarrays whose sum is exactly equal to K.
// Approach:
// - Use Prefix Sum + HashMap (frequency map).
// - Maintain a running prefix sum while traversing the array.
// - If (prefixSum - K) exists in the map, it means there are subarrays
//   ending at the current index whose sum is K.
// - Add the frequency of (prefixSum - K) to the answer.
// - Store/update the frequency of the current prefix sum.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;

public class CountSubarraysWithSumK {

    public static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        // Important initialization
        // To handle subarrays starting from index 0
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Check if (prefixSum - K) exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Store/update frequency of prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int k = 3;

        int result = countSubarrays(arr, k);
        System.out.println("Total subarrays with sum K: " + result);
    }
}
