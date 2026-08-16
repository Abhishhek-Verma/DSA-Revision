class Solution {
    Integer[][]dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new Integer [n][m];
        return solve(n-1,m-1,s,t);
    }
    private int solve(int i, int j, String s , String t){
        //matched whole string or empty string match to choose nothing
        if(j<0) return 1;
        //s ends but t left
        if(i<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j))
            return dp[i][j]= solve(i-1,j-1,s,t) + solve(i-1,j,s,t);
        return  dp[i][j]  = solve(i-1,j,s,t);
    }
}