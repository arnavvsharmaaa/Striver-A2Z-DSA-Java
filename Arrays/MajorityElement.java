// Problem: Majority Element
// Approach: Boyer-Moore Voting Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MajorityElement {

    public static int findMajority(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
            else if (nums[i] == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        return candidate; // majority element always exists
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(findMajority(nums));
    }
}
