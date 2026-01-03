// Problem: Move Zeroes to End
// Approach: Two Pointer Technique
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MoveZeroesEnd {

    public static void moveZeroes(int[] arr){
        int j = 0;

        for(int i = 0; i<arr.length;i++){

            if(arr[i]!= 0){
                int temp = arr[i];
                arr[i]= arr[j];
                arr[j] = temp;
                j++;

            }

        }

    }

    public static void main(String[] args){
        int[] arr = {1,0,2,3,0,4,0,1};

        moveZeroes(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }

    }
}
