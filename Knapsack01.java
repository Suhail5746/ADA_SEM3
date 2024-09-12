public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 2, 5};
        int[] v = {1, 3, 5, 3, 5};
        int W = 7;
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if(W>wt[i]  && (v[i]+dp[i-1][w-wt[i]]>dp[i-1][w])){
                        dp[i][w] = dp[i-1][w-wt[i]] + v[i];
                }
                else{
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
                    

    }
}
