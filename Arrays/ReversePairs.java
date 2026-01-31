// Problem: Reverse Pairs
//
// Description:
// Given an integer array nums, return the number of reverse pairs.
// A reverse pair (i, j) satisfies:
// i < j and nums[i] > 2 * nums[j].
//
// Approach:
// - Use Merge Sort.
// - While merging, count valid reverse pairs between left and right halves
//   using two pointers.
// - Merge the halves after counting.
//
// Time Complexity: O(n log n)
// Space Complexity: O(n)

public class ReversePairs {

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {

        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[low + p] = temp[p];
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 2, 3, 1};
        System.out.println("Reverse Pairs: " + reversePairs(nums));
    }
}
