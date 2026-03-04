1class Solution {
2    public int numDistinct(String s, String t) {
3        int n = s.length();
4        int m = t.length();
5        int[][]dp = new int [n+1][m+1];
6        for(int i=0;i<=n;i++) dp[i][m] = 1;
7
8        for(int i =n-1;i>=0;i--){
9            for(int j = m-1;j>=0;j--){
10                if(s.charAt(i)==t.charAt(j)){
11                    dp[i][j]= dp[i+1][j+1]+ dp[i+1][j];
12                }
13                else{
14                    dp[i][j]= dp[i+1][j];
15                }
16            }
17        }
18        return dp[0][0];
19    }
20}