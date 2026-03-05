1class Solution {
2    Integer[][][] dp;
3    public int maxPathScore(int[][] grid, int k) {
4        int m = grid.length;
5        int n = grid[0].length;
6        dp = new Integer[m][n][k+1];
7        int ans = solve(0,0,grid,m,n,k);
8        if(ans == Integer.MIN_VALUE) return -1;
9        return ans;
10    }
11    private int solve(int r,int c,int[][] a,int m,int n,int k){
12        int cost = a[r][c] == 0 ? 0 : 1;
13        int newK = k - cost;
14        if(newK < 0) return Integer.MIN_VALUE;
15        if(r == m-1 && c == n-1)
16            return a[r][c];
17        if(dp[r][c][k] != null)
18            return dp[r][c][k];
19        int down = Integer.MIN_VALUE;
20        int right = Integer.MIN_VALUE;
21        if(r+1 < m) down = solve(r+1,c,a,m,n,newK);
22        if(c+1 < n) right = solve(r,c+1,a,m,n,newK);
23        int best = Math.max(down,right);
24        if(best == Integer.MIN_VALUE)
25            return dp[r][c][k] = Integer.MIN_VALUE;
26        return dp[r][c][k] = a[r][c] + best;
27    }
28}