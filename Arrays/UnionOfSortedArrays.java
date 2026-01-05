// Problem: Union of Two Sorted Arrays
// Description:
// Given two sorted arrays arr1 and arr2 of sizes n and m respectively,
// find the union of the two arrays. The union contains all unique elements
// present in either of the arrays and the result should be in sorted order.
//
// Example:
// Input:
// arr1 = [1, 2, 2, 3, 4]
// arr2 = [2, 3, 5, 6]
//
// Output:
// [1, 2, 3, 4, 5, 6]
//
// Approach:
// Use the two-pointer technique to traverse both arrays simultaneously.
// Compare elements from both arrays, add the smaller element to the result
// while avoiding duplicates. If both elements are equal, add it once and
// move both pointers. After one array is exhausted, add the remaining
// unique elements from the other array.
//
// Time Complexity: O(n + m)
// Space Complexity: O(n + m)



import java.util.ArrayList;

public class UnionOfSortedArrays {

    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;
        int n = arr1.length;
        int m = arr2.length;

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
            else { // arr1[i] == arr2[j]
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        // Remaining elements of arr1
        while (i < n) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        // Remaining elements of arr2
        while (j < m) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 5, 6};

        ArrayList<Integer> result = findUnion(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
