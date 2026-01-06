// Problem: Maximum Consecutive 1s
// Approach: Single Pass Traversal
// Time Complexity: O(n)
// Space Complexity: O(1)

public class MaxConsecutiveOne {

    public static int findMaxConsecutiveOne(int[] arr){

        int maxCount = 0;
        int currentCount = 0;

        for(int i = 0; i<arr.length;i++){

            if(arr[i] == 1){
                currentCount++;
                maxCount= Math.max(maxCount,currentCount);

            }else{
                currentCount = 0;

            }
        }
        return maxCount;

    }

    public static void main (String[] args){

        int[] arr = {1,1,0,1,1,1};

        System.out.println(findMaxConsecutiveOne(arr));

    }
}
