1class Solution {
2    public boolean isMatch(String s, String p) {
3        int n = s.length();
4        int m = p.length();
5        Boolean [][]dp = new Boolean[n+1][m+1];
6        return solve(n,m,s,p,dp);
7    }
8    private static boolean solve(int n, int m, String s, String p,Boolean[][]dp){
9        if(n==0 && m==0) return true;
10        if(n>0 && m==0) return false;
11        if(n==0 && m>0){
12            for(int x=1;x<=m;x++){
13                if(p.charAt(x-1)!='*') return false;
14            }
15           return  dp[n][m]= true;
16        }
17        if(dp[n][m] != null) return dp[n][m];
18     if(s.charAt(n-1)==p.charAt(m-1) || p.charAt(m-1)=='?') {
19        dp[n][m]= solve(n-1,m-1,s,p,dp);
20        return dp[n][m];
21
22     }
23     if(p.charAt(m-1)=='*') {
24     return  dp[n][m]=  solve(n-1,m,s,p,dp) || solve(n,m-1,s,p,dp);
25
26     }
27    return dp[n][m]= false;
28    } 
29}