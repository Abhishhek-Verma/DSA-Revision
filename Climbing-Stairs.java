1class Solution {
2    public int climbStairs(int n) {
3        Integer[]dp = new Integer[n+1];
4       return solve(n,dp);
5    }
6    private int solve(int n, Integer[]dp){
7        if(n==0) return 1;
8        if(n==1) return 1;
9        if(dp[n]!=null) return dp[n];
10        int left = solve(n-1,dp);
11        int right = solve(n-2,dp);
12        return dp[n]= left+right;
13    }
14}