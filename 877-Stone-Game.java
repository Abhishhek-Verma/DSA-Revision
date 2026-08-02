class Solution {
    Integer[][][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n][2];
        int alice = solve(piles, 0, n - 1, 1);
        int total = 0;
        for (int x : piles) total += x;
        int bob = total - alice;
        return alice > bob;
    }
    public int solve(int[] piles, int i, int j, int turn) {
        if (i > j)  return 0;
        if (dp[i][j][turn] != null) return dp[i][j][turn];
        if (turn == 1) { 
            int takeFirst = piles[i] + solve(piles, i + 1, j, 0);
            int takeLast = piles[j] + solve(piles, i, j - 1, 0);
            return dp[i][j][turn] = Math.max(takeFirst, takeLast);
        } 
        else { 
            int takeFirst = solve(piles, i + 1, j, 1);
            int takeLast = solve(piles, i, j - 1, 1);
            return dp[i][j][turn] = Math.min(takeFirst, takeLast);
        }
    }
}