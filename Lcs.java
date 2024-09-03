public class Lcs {
    static int lcs_recur(String s1,String s2,int i,int j){
        if(i==0 || j==0)
            return 0;
        if(s1.charAt(i-1)==s2.charAt(j-1))
          return 1+lcs_recur(s1,s2,i-1,j-1);
        else
        return Math.max(lcs_recur(s1,s2,i,j-1),lcs_recur(s1,s2,i-1,j));
    }
        
    //using dp
    static int lcs_dp(String s1,String s2,int i,int j,int[][] dp){
        if(i==0 || j==0)
          return 0;
        if(dp[i][j]!=0)
          return dp[i][j];
        
        if(s1.charAt(i-1)==s2.charAt(j-1))
          return dp[i][j]=lcs_dp(s1,s2,i-1,j-1,dp)+1;
        else
           return dp[i][j]=Math.max(lcs_dp(s1,s2,i,j-1,dp),lcs_dp(s1,s2,i-1,j,dp));
        
        
    }

    //print lcs
    static void print_lcs(String s1,String s2,int i,int j,int[][] dp){
      if(i==0 || j==0)
      return ;
      if(s1.charAt(i-1)==s2.charAt(j-1)){
        System.out.print(s1.charAt(i-1)+" ");
        print_lcs(s1,s2,i-1,j-1,dp);
      }
      else if(dp[i][j-1]>dp[i-1][j])
      {
        print_lcs(s1,s2,i,j-1,dp);
      }
      else
      {
        print_lcs(s1,s2,i-1,j,dp);
      }
    }

        
        
    
        
            
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        System.out.println("Length of lcs_recur is " + lcs_recur(s1, s2, m,n));
        System.out.println("Length of lcs_dp is " + lcs_dp(s1, s2,m,n,dp));
        System.out.println("LCS is ");
        print_lcs(s1,s2,m,n,dp);
    }
}
