1class Solution {
2    public int uniquePathsWithObstacles(int[][] mm) {
3      int m = mm.length;
4        int n = mm[0].length;
5        if(mm[0][0]==1) return 0;
6        Integer[][] dp = new Integer[m][n];
7        return solve(0,0,mm,m,n,dp);
8    }
9
10    private int solve(int r,int c,int[][] a,int m,int n,Integer[][] dp){
11        if(r>=m || c>=n || a[r][c]==1) return 0;
12        if(r==m-1 && c==n-1) return 1;
13        if(dp[r][c]!=null) return dp[r][c];
14        int down = solve(r+1,c,a,m,n,dp);
15        int right = solve(r,c+1,a,m,n,dp);
16        return dp[r][c]=down+right;
17}
18}