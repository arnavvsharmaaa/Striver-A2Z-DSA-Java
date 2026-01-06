// Problem: Single Number
// Approach: XOR Operation
// Time Complexity: O(n)
// Space Complexity: O(1)

public class SingleNumber {

    public static int findSingle(int[] arr){
        int xor = 0;

        for(int i = 0;  i <arr.length;i++){
            xor = xor ^ arr[i];
        }
        return xor;


    }
    public static void main(String[] args){

        int[] arr = {4,1,2,1,2};

        System.out.println(findSingle(arr));



    }
}
