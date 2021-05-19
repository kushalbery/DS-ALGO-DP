public class CountNumberOfSubSetWithGivenDiff {
    
    static int countSubSet(int arr[], int sum, int n) {
        int t[][] = new int[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            t[i][0] = 1;
        }
        for (int i = 1; i < sum + 1; i++) {
            t[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j)
                    t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }

    static int countNumberOfSubSetWithGivenDiff(int arr[], int diff, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int s1 = (diff + sum)/2;
        return countSubSet(arr, s1, n);
    }

    public static void main(String[] args) {
        int val[] = new int[] {1,1,2,3};
        int n = val.length;
        System.out.println(countNumberOfSubSetWithGivenDiff(val, 1, n));
    }
}
