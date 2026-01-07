// Problem: Maximum Subarray Sum
// Approach: Kadane’s Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MaximumSubarraySum {

    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
