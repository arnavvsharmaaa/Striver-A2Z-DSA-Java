// Problem: Find the Missing Number
// Approach: Sum Formula
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MissingNumberInArray {
    public static int findMissing(int[] arr, int n ){

        int expectedSum = n*(n+1)/2;
        int actualSum = 0;

        for(int i = 0; i <arr.length; i++){
            actualSum+=arr[i];


        }

        return expectedSum -actualSum;



    }


    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7,9};

        int n = 9;

        System.out.println(findMissing(arr,n));


    }
}
