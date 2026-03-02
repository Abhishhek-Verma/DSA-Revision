1class Solution {
2    static Integer[][]dp;
3    public int minDistance(String s, String t) {
4        int n = s.length();
5        int m = t.length();
6        dp = new Integer[n][m];
7        return solve(s,t,n-1,m-1);
8    }
9    private int solve(String s, String t, int i , int j){
10        if(i<0) return j+1;
11        if(j<0) return i+1;
12        if(dp[i][j]!=null) return dp[i][j];
13        if(s.charAt(i)==t.charAt(j)) 
14               return solve(s,t,i-1,j-1);
15        
16            int insert =1+ solve(s,t,i,j-1);
17            int  del = 1+solve(s,t,i-1,j);
18            int rep = 1+solve(s,t,i-1,j-1);
19
20            return dp[i][j] = Math.min(insert,Math.min(del, rep));
21    }
22}