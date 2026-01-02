// Problem: Remove Duplicates from Sorted Array
// Approach: Two Pointer Technique
// Time Complexity: O(n)
// Space Complexity: O(1)

public class RemoveDuplication{

    public static int removeDuplicates(int[] arr){
        if (arr.length == 0){
            return 0;

        }

        int i = 0 ;

        for(int j = 1; j < arr.length; j++){

            if( arr[j]!= arr[i]){
                i++;
                arr[i] = arr[j];

            }
        }
        return i+1;

        }

    public static void main( String[] args ){

        int[] arr = {1,1,2,2,3};
        int k = removeDuplicates(arr);

        System.out.println("Unique count" + k);
        for(int i = 0;i<k ;i++){
            System.out.print(arr[i] + " ");
        }



    }


}
