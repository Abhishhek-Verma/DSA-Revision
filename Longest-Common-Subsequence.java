1class Solution {
2    public int longestCommonSubsequence(String s, String t) {
3         int[][] dp = new int[s.length()][t.length()];
4        for(int[] r: dp) Arrays.fill(r,-1);
5        return f(0,0,s,t,dp);
6    }
7    private int f(int i,int j,String s,String t,int[][] dp){
8        if(i==s.length() || j==t.length()) return 0;
9        if(dp[i][j]!=-1) return dp[i][j];
10        if(s.charAt(i)==t.charAt(j))
11            return dp[i][j]=1+f(i+1,j+1,s,t,dp);
12        return dp[i][j]=Math.max(f(i+1,j,s,t,dp),f(i,j+1,s,t,dp));
13    }
14}