// Problem: 4 Sum
//
// Description:
// Given an integer array nums and an integer target, return all unique
// quadruplets [nums[a], nums[b], nums[c], nums[d]] such that their sum
// is equal to target. The solution set must not contain duplicate quadruplets.
//
// Approach:
// - Sort the array.
// - Fix first two indices i and j.
// - Use two pointers for remaining two indices.
// - Skip duplicates carefully to avoid repeated quadruplets.
//
// Time Complexity: O(n^3)
// Space Complexity: O(1) (excluding output list)

import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;

                    } 
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(fourSum(nums, target));
    }
}
