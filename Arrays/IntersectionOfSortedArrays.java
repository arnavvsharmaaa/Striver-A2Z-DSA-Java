import java.util.ArrayList;

// Problem: Intersection of Two Sorted Arrays
// Approach: Two Pointer Technique
// Time Complexity: O(n + m)
// Space Complexity: O(n + m)

public class IntersectionOfSortedArrays {

    public static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2) {

        ArrayList<Integer> intersection = new ArrayList<>();

        int i = 0, j = 0;
        int n = arr1.length;
        int m = arr2.length;

        while (i < n && j < m) {

            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                j++;
            }
            else { // arr1[i] == arr2[j]
                if (intersection.size() == 0 ||
                    intersection.get(intersection.size() - 1) != arr1[i]) {
                    intersection.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        return intersection;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 3, 5};

        ArrayList<Integer> result = findIntersection(arr1, arr2);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
