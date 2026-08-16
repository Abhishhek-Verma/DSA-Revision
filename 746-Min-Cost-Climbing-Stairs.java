class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new Integer[n];
        return Math.min(solve(0, cost), solve(1, cost));
    }
    private int solve(int i, int[] cost) {
        if (i >= cost.length)
            return 0;
        if (dp[i] != null)
            return dp[i];
        dp[i] = cost[i] + Math.min(solve(i + 1, cost),solve(i + 2, cost));
        return dp[i];
    }
}