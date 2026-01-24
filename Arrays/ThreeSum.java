// Problem: 3 Sum
//
// Description:
// Given an integer array nums, return all unique triplets
// [nums[i], nums[j], nums[k]] such that their sum is 0.
// The solution set must not contain duplicate triplets.
//
// Approach:
// - Sort the array.
// - Fix one element and use two pointers to find remaining two.
// - Skip duplicates to avoid repeated triplets.
//
// Time Complexity: O(n^2)
// Space Complexity: O(1) (excluding output list)

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate left
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // Skip duplicate right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
