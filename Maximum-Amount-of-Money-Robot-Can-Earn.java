1class Solution {
2    Integer[][][] dp;
3    public int maximumAmount(int[][] coins) {
4        int m = coins.length;
5        int n = coins[0].length;
6        dp = new Integer[m][n][3];
7        return solve(0,0,2,coins,m,n);
8    }
9    private int solve(int r,int c,int k,int[][] a,int m,int n){
10        if(r==m-1 && c==n-1){
11            if(a[r][c] >= 0) return a[r][c];
12            if(k > 0) return 0;
13            return a[r][c];
14        }
15        if(dp[r][c][k] != null)return dp[r][c][k];
16
17        int down = Integer.MIN_VALUE;
18        int right = Integer.MIN_VALUE;
19        if(r+1 < m) down = solve(r+1,c,k,a,m,n);
20        if(c+1 < n) right = solve(r,c+1,k,a,m,n);
21
22        int best = Integer.MIN_VALUE;
23
24        if(a[r][c] >= 0){
25            best = a[r][c] + Math.max(down,right);
26        }
27        else{
28            int take = a[r][c] + Math.max(down,right);
29            int neutral = Integer.MIN_VALUE;
30            if(k > 0){
31                int d2 = Integer.MIN_VALUE;
32                int r2 = Integer.MIN_VALUE;
33                if(r+1 < m) d2 = solve(r+1,c,k-1,a,m,n);
34                if(c+1 < n) r2 = solve(r,c+1,k-1,a,m,n);
35                neutral = Math.max(d2,r2);
36            }
37            best = Math.max(take, neutral);
38        }
39        return dp[r][c][k] = best;
40    }
41}