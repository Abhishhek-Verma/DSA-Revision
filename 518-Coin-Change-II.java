class Solution {
    public int change(int k, int[] arr) {
         Arrays.sort(arr);
        Integer[][] dp = new Integer[arr.length][k + 1];
       return solve(arr, k, arr.length - 1, dp);
    }
    private int solve(int[] arr, int k, int idx, Integer[][] dp) {
        if (k == 0) return 1;
        if (idx < 0 || k < 0) return 0;
        if (dp[idx][k] != null) return dp[idx][k];
        int take = solve(arr, k - arr[idx], idx, dp);
        int notTake = solve(arr, k, idx - 1, dp);
        return dp[idx][k] = take + notTake;
    }
}