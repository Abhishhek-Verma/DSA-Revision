1class Solution {
2    public int uniquePaths(int m, int n) {
3        Integer[][] dp = new Integer [m][n];
4        for(Integer[] x: dp) Arrays.fill(x,-1);
5         return solve(m-1,n-1,dp);
6    }
7    private int solve(int m , int n , Integer[][]dp){
8        if(m==0 || n==0) return 1;
9        if(dp[m][n]!=-1) return dp[m][n];
10         return dp[m][n] = solve(m-1,n,dp) + solve(m,n-1,dp);
11    }
12}