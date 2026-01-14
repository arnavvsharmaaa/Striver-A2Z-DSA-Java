// Problem: Leaders in an Array
//
// Description:
// Given an array of integers, find all the leaders in the array.
// An element is a leader if all elements to its right are smaller than it.
// The rightmost element is always a leader.
//
// Approach:
// - Traverse the array from right to left.
// - Keep track of the maximum element seen so far.
// - If the current element is greater than or equal to maxSoFar,
//   it is a leader.
//
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    public static ArrayList<Integer> findLeaders(int[] arr) {

        ArrayList<Integer> leaders = new ArrayList<>();
        int maxSoFar = arr[arr.length - 1];

        leaders.add(maxSoFar);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxSoFar) {
                maxSoFar = arr[i];
                leaders.add(arr[i]);
            }
        }

        // Reverse to maintain original order
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {

        int[] arr = {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> result = findLeaders(arr);

        System.out.println(result);
    }
}
