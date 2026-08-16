class Solution {
    
    /*1312
       ↓
      LPS
       ↓
   LCS(s, reverse(s))
       ↓
   n - LCS*/


    Integer[][] dp;
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        dp = new Integer[n][n];
        int lcs = solve(s, rev, n - 1, n - 1);
        return n - lcs;
    }
    private int solve(String s, String rev, int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i) == rev.charAt(j)) {
            return dp[i][j] =1 + solve(s, rev, i - 1, j - 1);
        }

        return dp[i][j] = Math.max(solve(s, rev, i - 1, j),solve(s, rev, i, j - 1));
    }
}