1class Solution {
2    //private int ans = Integer.MAX_VALUE;
3    public int coinChange(int[] arr, int k) {
4         Arrays.sort(arr);
5        Integer[][] dp = new Integer[arr.length][k + 1];
6        int res = solve(arr, k, arr.length - 1, dp);
7        return res == Integer.MAX_VALUE ? -1 : res;
8    }
9    private int solve(int[] arr, int k, int idx, Integer[][] dp) {
10        if (k == 0) return 0;
11        if (idx < 0 || k < 0) return Integer.MAX_VALUE;
12        if (dp[idx][k] != null) return dp[idx][k];
13        int take = Integer.MAX_VALUE;
14        if (arr[idx] <= k) {
15            int temp = solve(arr, k - arr[idx], idx, dp);
16            if (temp != Integer.MAX_VALUE)
17                take = 1 + temp;
18        }
19        int notTake = solve(arr, k, idx - 1, dp);
20        return dp[idx][k] = Math.min(take, notTake);
21    }
22}