import java.util.Scanner;

public class BinomialCoefficient {

  // Recursive method to calculate binomial coefficient C(n, k)
  public static int bin1(int n, int k) {
      // Base cases
      if (k == 0 || k == n) {
          return 1;
      }
      // Recursive cases
      return bin1(n - 1, k - 1) + bin1(n - 1, k);
  }

  //dp memoization
  public static int bin2(int n, int k) {
    int[][] dp = new int[n+1][n+1];
    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <=i; j++) {
            if(j == 0 || j == i) {
                dp[i][j] = 1;
            }
            else {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
    return dp[n][k];
  }

  public static int bin_sparse(int n, int k) {
    int[][] dp = new int[n+1][];
    for(int i = 0; i <= n; i++) {
        dp[i] = new int[i+1];
    }


    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <=i; j++) {
            if(j == 0 || j == i) {
                dp[i][j] = 1;
            }
            else {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
    return dp[n][k];
  }

  public static int bin3(int n, int k) {
    int[][] dp = new int[n+1][k+1];
    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <= Math.min(i, k); j++) {
            if(j == 0 || j == i) {
                dp[i][j] = 1;
            }
            else {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
    return dp[n][k];
  }

  //using 1d dp of size n
  public static int bin4(int n, int k) {
    int[] dp = new int[n+1];
    dp[0] = 1;
    for(int i = 1; i <= n; i++) {
        for(int j = i; j > 0; j--) {
            if(j == 0 || j == i) {
                dp[j] = 1;
            }
            else {
                dp[j] = dp[j-1] + dp[j];
            }
        }
    }
    return dp[k];
    }


  //using 1d dp
   public static int bin5(int n, int k) {
    int[] dp = new int[k+1];
    dp[0] = 1;
    for(int i = 1; i <= n; i++) {
        for(int j = Math.min(i, k); j > 0; j--) {
            dp[j] = dp[j] + dp[j-1];
        }
    }
    return dp[k];
}




  public static void main(String[] args) {
    //take input from user
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of n = ");
    int n = sc.nextInt();
    System.out.println("Enter the value of k = ");
    int k = sc.nextInt();


      
      System.out.println("C(" + n + ", " + k + ") = " + bin1(n, k));
      System.out.println("C(" + n + ", " + k + ") = " + bin2(n, k));
      System.out.println("C(" + n + ", " + k + ") = " + bin3(n, k));
      System.out.println("C(" + n + ", " + k + ") = " + bin4(n, k));
      System.out.println("C(" + n + ", " + k + ") = " + bin5(n, k));
      System.out.println("C(" + n + ", " + k + ") = " + bin_sparse(n, k));
  }
}
