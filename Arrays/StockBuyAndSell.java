// Problem: Count Number of Subarrays with XOR K
//
// Description:
// Given an integer array and an integer K, count the number
// of contiguous subarrays whose XOR is equal to K.
//
// Approach:
// - Use Prefix XOR + HashMap.
// - Maintain running prefix XOR.
// - If (prefixXOR ^ K) exists in the map, then valid subarrays exist.
// - Store frequency of prefix XORs.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;

public class CountSubarraysWithXORK {

    public static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int prefixXOR = 0;
        int count = 0;

        for (int num : arr) {
            prefixXOR ^= num;

            int required = prefixXOR ^ k;
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(prefixXOR, map.getOrDefault(prefixXOR, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println("Count of subarrays with XOR " + k + ": "
                + countSubarrays(arr, k));
    }
}
