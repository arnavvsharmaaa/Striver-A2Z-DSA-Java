// Problem: Longest Consecutive Sequence
//
// Description:
// Given an unsorted array of integers, find the length of the
// longest consecutive elements sequence.
// The sequence does not need to be contiguous.
//
// Approach:
// - Store all elements in a HashSet.
// - For each element, check if it is the start of a sequence
//   (i.e., element - 1 does not exist).
// - Count consecutive elements and update the maximum length.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start counting only if it's the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: "
                + longestConsecutive(arr));
    }
}
