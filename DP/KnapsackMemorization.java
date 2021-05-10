public class KnapsackMemorization {

    static int max(int a, int b) {
        return a > b ? a : b; 
    }

    static int KnapSackMemorization(int wt[], int val[], int w, int n, int [][]dp) {
        if (n == 0 || w == 0)
            return 0;
        
        if (dp[n][w] != -1)
            return dp[n][w];
        
        if (wt[n-1] <= w)
            return dp[n][w] = max(val[n-1] + KnapSackMemorization(wt, val, w - wt[n-1], n-1, dp), KnapSackMemorization(wt, val, w, n-1, dp));
        else
            return dp[n][w] = KnapSackMemorization(wt, val, w, n-1, dp);
    }

    static int knapSack(int wt[], int val[], int w, int n) {
        int dp[][] = new int[n+1][w+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                dp[i][j] = -1;
            }
        }

        return KnapSackMemorization(wt, val, w, n, dp);
    }

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(wt, val, W, n));
    }
    
}
