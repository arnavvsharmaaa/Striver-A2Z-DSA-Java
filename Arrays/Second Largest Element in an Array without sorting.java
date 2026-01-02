// Problem: Second Largest Element in an Array
// Approach: Single traversal using two variables
// Time Complexity: O(n)
// Space Complexity: O(1)

public class SecondLargest {
    public static int findSecondLargest(int[] arr){

        if(arr.length<2){
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0;i<arr.length;i++){
            if(arr[i]> largest){
                secondLargest = largest;
                largest = arr[i];
            }

            else if (arr[i]<largest && arr[i]> secondLargest){
                secondLargest = arr[i];
            }
        }
        //second largest never updated
        if(secondLargest == Integer.MIN_VALUE){
            return -1;
        }

        return secondLargest;

    }


    public static void main(String[] args){
        int[] arr = {12,35,1,10,34,1};
        System.out.println(findSecondLargest(arr));


    }
}
