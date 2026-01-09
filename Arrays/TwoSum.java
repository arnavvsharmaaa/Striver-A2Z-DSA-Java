// Problem: Two Sum

// Description:
// Given an array of integers and an integer target,
// return indices of the two numbers such that they add up to the target.
// You may assume that each input has exactly one solution,
// and you may not use the same element twice.

// Approach:
// - Use a HashMap to store numbers and their indices.
// - For each element, calculate the required complement (target - current element).
// - If the complement exists in the map, return the indices.
// - Otherwise, store the current element with its index.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        // As per problem statement, one solution always exists
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
