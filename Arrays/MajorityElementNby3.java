// Problem: Majority Element (n/3 times)
//
// Description:
// Given an integer array nums, find all elements that appear
// more than floor(n/3) times.
// There can be at most two such elements.
//
// Approach:
// - Use modified Boyer-Moore Voting Algorithm.
// - Maintain two candidates and their counts.
// - First pass finds potential candidates.
// - Second pass verifies their actual frequency.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

import java.util.*;

public class MajorityElementNby3 {

    public static List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Phase 1: Find potential candidates
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            } 
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } 
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        // Phase 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }
}
