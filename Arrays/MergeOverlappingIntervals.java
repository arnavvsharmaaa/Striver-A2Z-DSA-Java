// Problem: Merge Overlapping Intervals
//
// Description:
// Given a list of intervals, merge all overlapping intervals
// and return the list of non-overlapping intervals.
//
// Approach:
// - Sort intervals based on start time.
// - Traverse intervals and merge if overlapping.
// - If not overlapping, add as a new interval.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

import java.util.*;

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][0];

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {

            int[] next = intervals[i];

            // If overlapping
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } 
            else {
                current = next;
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] merged = merge(intervals);

        for (int[] in : merged) {
            System.out.println(Arrays.toString(in));
        }
    }
}
