// Problem: Print Subarray with Maximum Sum
//
// Description:
// Given an integer array, find the contiguous subarray
// with the maximum sum and print that subarray.
//
// Approach:
// - Use Kadane’s Algorithm with index tracking.
// - Maintain a running sum.
// - If the running sum becomes negative, reset it and
//   move the start pointer.
// - Track start and end indices whenever a new maximum sum is found.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class PrintMaximumSubarray {

    public static void printMaxSubarray(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        int start = 0;
        int ansStart = 0;
        int ansEnd = 0;

        for (int i = 0; i < arr.length; i++) {

            if (currentSum == 0) {
                start = i;
            }

            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                ansStart = start;
                ansEnd = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Printing result
        System.out.println("Maximum Subarray Sum: " + maxSum);
        System.out.print("Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        printMaxSubarray(arr);
    }
}
