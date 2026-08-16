class Solution {
    Integer[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0;
        for (int x : stones) {
            total += x;
        }
        int target = total / 2;
        dp = new Integer[n][target + 1];
        int best = solve(0, target, stones);
        return total - 2 * best;
    }
    private int solve(int i, int target, int[] stones) {
        if (i == stones.length || target == 0)
            return 0;
        if (dp[i][target] != null)
            return dp[i][target];
        // Don't take current stone
        int notTake = solve(i + 1, target, stones);
        // Take current stone if possible
        int take = 0;
        if (stones[i] <= target) {
            take = stones[i]+ solve(i + 1, target - stones[i], stones);
        }
        return dp[i][target] = Math.max(take, notTake);
    }
}