1class Solution {
2    Integer[][]dp;
3    public int numDistinct(String s, String t) {
4        int n = s.length();
5        int m = t.length();
6        dp = new Integer [n][m];
7        return solve(n-1,m-1,s,t);
8    }
9    private int solve(int i, int j, String s , String t){
10        if(j<0) return 1;
11        if(i<0) return 0;
12        if(dp[i][j]!=null) return dp[i][j];
13        if(s.charAt(i)==t.charAt(j))
14            return dp[i][j]= solve(i-1,j-1,s,t) + solve(i-1,j,s,t);
15        return  dp[i][j]  = solve(i-1,j,s,t);
16    }
17}