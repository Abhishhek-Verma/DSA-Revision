1class Solution {
2    Integer[][]dp;
3    int mod = 1000000007;
4    public int countCoprime(int[][] mat) {
5        dp = new Integer[mat.length][151];
6        return solve(0, 0, mat);
7    }
8    private int solve(int row, int g, int[][] mat) {
9        if(row == mat.length){
10            if(g == 1) return 1;
11            return 0;
12        }
13        if(dp[row][g]!=null) return dp[row][g];
14        int ans = 0;
15        for(int x : mat[row]){
16            int newg;
17            if(g == 0) newg = x;
18            else newg = gcd(g, x);
19            ans = (ans + solve(row + 1, newg, mat)) % mod;
20        }
21        return dp[row][g]=ans;
22    }
23    private int gcd(int a, int b){
24        while(b != 0){
25            int t = a % b;
26            a = b;
27            b = t;
28        }
29        return a;
30    }
31}
32