// Problem: Left Rotate Array by K Places
// Approach: Reversal Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)


public class LeftRotateByK {

    public static void reverse(int[] arr , int start , int end ){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }
    public static void leftRotateByK(int[]arr , int k ){
        int n = arr.length;
        k = k%n;//rule of modulo if k<n then k%n = k

        reverse(arr,0,k-1);
        reverse(arr, k ,n-1);
        reverse(arr, 0,n-1);

    }
    public static void main(String[] args){

        int[] arr = {1,2,3,4,5};

        int k = 2;

        leftRotateByK(arr,k);

        for (int num : arr){
            System.out.print(num + " ");

        }



    }
}
