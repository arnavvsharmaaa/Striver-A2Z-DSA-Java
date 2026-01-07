// Problem: Longest Subarray with Sum K (Positive Integers)
// Approach: Sliding Window
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LongestSubarraySumK {

    public static int longestSubarray(int[] arr, int k) {

        int left = 0, right = 0;
        int sum = 0;
        int maxLen = 0;

        while (right < arr.length) {

            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 1, 1, 1, 3};
        int k = 3;

        System.out.println(longestSubarray(arr, k));
    }
}
