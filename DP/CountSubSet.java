/*
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a sum equal to X.

Examples: 

Input: arr[] = {1, 2, 3, 3}, X = 6 
Output: 3 
All the possible subsets are {1, 2, 3}, 
{1, 2, 3} and {3, 3}
 

Input: arr[] = {1, 1, 1, 1}, X = 1 
Output: 4 

https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
*/

public class CountSubSet {

    static int countSubSet(int[] arr, int sum, int n) {
        int t[][] = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                else if (j == 0)
                    t[i][j] = 1;
                else if (arr[i-1] <= j)
                    t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }
    public static void main(String[] args) {
        int val[] = new int[] {1, 1, 1, 1};
        int n = val.length;
        System.out.println(countSubSet(val, 1, n));
    }
}
