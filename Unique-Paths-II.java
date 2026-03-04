1class Solution {
2    public int uniquePathsWithObstacles(int[][] mm) {
3        int m = mm.length;
4        int n = mm[0].length;
5       int[][]dp = new int[m][n];
6        for(int i =0;i<m;i++){
7            for(int j =0;j<n;j++){
8                if(mm[i][j]==1) dp[i][j]= 0;
9                else if(i==0 && j==0){ 
10                    dp[i][j]=1;
11                }
12                else{
13                    int up=0,down=0;
14                   if(i>0) up =dp[i-1][j];
15                    if(j>0) down =dp[i][j-1];
16                dp[i][j]= up+down;
17                }
18            }
19        }
20    return dp[m-1][n-1];
21}
22}