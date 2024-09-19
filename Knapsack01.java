public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 2, 5}; 
        int[] v = {1, 3, 5, 3, 5};  
        int W = 7; 
        int n = wt.length;

        
        int[][] dp = new int[n + 1][W + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
              
                if (w >= wt[i - 1]) {
                    
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + v[i - 1]);
                } else {
                    
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum value in Knapsack = " + dp[n][W]);
    }
}
