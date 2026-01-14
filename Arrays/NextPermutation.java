// Problem: Next Permutation
//
// Description:
// Given an array of integers, rearrange the numbers into
// the lexicographically next greater permutation.
// If no such permutation exists, rearrange into the lowest
// possible order (ascending).
//
// Approach:
// 1. Find the first index from the right where arr[i] < arr[i+1].
// 2. If no such index exists, reverse the entire array.
// 3. Find the smallest element greater than arr[i] on the right.
// 4. Swap and reverse the remaining array.
//
// Time Complexity: O(n)
// Space Complexity: O(1)

public class NextPermutation {

    public static void nextPermutation(int[] nums) {

        int n = nums.length;
        int index = -1;

        // Step 1: Find breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        // Step 2: If no breakpoint, reverse whole array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find element just greater than nums[index]
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Step 4: Reverse right part
        reverse(nums, index + 1, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
