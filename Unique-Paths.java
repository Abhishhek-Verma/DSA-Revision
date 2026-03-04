1class Solution {
2    Integer[][]dp;
3    public int uniquePaths(int m, int n) {
4        dp = new Integer[m][n];
5      return  solve(m-1,n-1);
6    }
7    private int solve(int i , int j){
8         if(i==0 && j==0) return 1;
9         if(i<0 || j<0) return 0;
10         if(dp[i][j]!=null) return dp[i][j];
11         int up = solve(i-1,j);
12         int down = solve(i,j-1);
13         return dp[i][j]= up+down;
14    }
15}