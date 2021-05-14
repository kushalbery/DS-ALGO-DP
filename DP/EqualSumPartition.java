/*
Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same. 

Examples: 

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.

https://www.geeksforgeeks.org/partition-problem-dp-18/
*/

public class EqualSumPartition {
    static boolean subSetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean t[][] = new boolean[n+1][sum+1];
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                if(i == 0)
                    t[i][j] = false;
                else if(j == 0)
                    t[i][j] = true;
                else if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }

    static boolean equalSumPartition(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum%2 != 0) 
            return false;
        else
            return subSetSum(arr, sum/2);
    }

    public static void main(String[] args) {
        int val[] = new int[] {1, 5, 11, 5};
        System.out.println(equalSumPartition(val));
    }
}
