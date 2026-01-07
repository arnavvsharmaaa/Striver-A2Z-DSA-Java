// Problem: Sort Colors
// Approach: Dutch National Flag Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)

public class SortColors {

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
