/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

Example: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30. 

https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
*/

public class SubSetSum {
    static boolean solve(int[] arr, int sum) {
        int n = arr.length;
        boolean t[][] = new boolean[n+1][sum+1];

		// Initialize first column as true.
		// 0 sum is possible with all elements.
		for (int i = 0; i <= n; i++)
			t[i][0] = true;
	
		// Initialize top row, except dp[0][0],
		// as false. With 0 elements, no other
		// sum except 0 is possible
		for (int i = 1; i <= sum; i++)
			t[0][i] = false;

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < sum+1; j++) {
                // if(i == 0)
                //     t[i][j] = false;
                // else if(j == 0)
                //     t[i][j] = true;
                if(arr[i-1] <= j)
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }  
    
    public static void main(String[] args) {
        int val[] = new int[] {3, 34, 4, 12, 5, 2};
        System.out.println(solve(val, 10));
    }
}
