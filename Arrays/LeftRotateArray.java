// Problem: Left Rotate Array by One Place
// Approach: Store first element and shift others
// Time Complexity: O(n)
// Space Complexity: O(1)

public class LeftRotateArray {
    public static void leftRotateArray(int[] arr){
        if(arr.length<1){
            return;
        }

        int first = arr[0];

        for(int i = 1;i<arr.length;i++){
            arr[i-1] = arr[i];


        }

        arr[arr.length - 1 ] = first;

    }

    public static void main(String[] args){
        int[]arr= {1,2,3,4,5};

        leftRotateArray(arr);
// enhanced for loop indexes through each element of arr without actually using single indexes
        for(int num : arr){
            System.out.print(num + " ");


        }

    }
}
