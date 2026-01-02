// Problem: Check if an Array is Sorted
// Approach: Compare adjacent elements
// Time Complexity: O(n)
// Space Complexity: O(1)

public class CheckArraySorted {

    public static boolean isSorted(int[] arr){

        for (int i = 1; i<arr.length;i++){

            if(arr[i-1] > arr[i] ){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,3,4};
        System.out.println(isSorted(arr));
    }
}
