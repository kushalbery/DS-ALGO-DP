import java.io.*;

public class MinSubSetSumDifference {

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int solve(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        boolean t[][] = new boolean [n+1][sum+1];
        
		// Initialize first column as true.
		// 0 sum is possible with all elements.
		for (int i = 0; i <= n; i++)
			t[i][0] = true;
	
		// Initialize top row, except dp[0][0],
		// as false. With 0 elements, no other
		// sum except 0 is possible
		for (int i = 1; i <= sum; i++)
			t[0][i] = false;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] <= j)
                    t[i][j] = t[i-1][j] || t[i-1][j - arr[i-1]];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        for (int i = 0; i < sum +1; i++) {
            System.out.println(t[3][i]);
        }
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= sum/2; i++) {
            if (t[n][i] == true) {
                diff = min(diff, sum - 2*i);
            }
        }
        return diff;
    }
    public static void main(String[] args) {
        int val[] = new int[] {1,2,7};
        int n = val.length;
        System.out.println(solve(val, n));
    }
    
}
