1class Solution {
2    public int longestPalindromeSubseq(String s) {
3        int[][] dp = new int[s.length()][s.length()];
4        StringBuilder sb = new StringBuilder (s);
5        sb.reverse();
6        String t = sb.toString();
7        for(int[] r: dp) Arrays.fill(r,-1);
8        return f(0,0,s,t,dp);
9    }
10    private int f(int i,int j,String s,String t,int[][] dp){
11        if(i==s.length() || j==t.length()) return 0;
12        if(dp[i][j]!=-1) return dp[i][j];
13        if(s.charAt(i)==t.charAt(j))
14            return dp[i][j]=1+f(i+1,j+1,s,t,dp);
15        return dp[i][j]=Math.max(f(i+1,j,s,t,dp),f(i,j+1,s,t,dp));
16    }
17}