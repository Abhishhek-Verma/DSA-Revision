1class Solution {
2    Integer[][][] dp;
3    public int minArraySum(int[] nums, int k, int op1, int op2) {
4        int n = nums.length;
5        dp = new Integer[n][op1 + 1][op2 + 1];
6        return solve(0, op1, op2, nums, k);
7    }
8    private int solve(int i, int d, int s, int[] nums, int k) {
9        if (i == nums.length) return 0;
10        if (dp[i][d][s] != null) return dp[i][d][s];
11        int ans = nums[i] + solve(i + 1, d, s, nums, k);
12
13        if (d > 0) {
14            int v = (nums[i] + 1) / 2;
15            ans = Math.min(ans, v + solve(i + 1, d - 1, s, nums, k));
16        }
17        if (s > 0 && nums[i] >= k) {
18            int v = nums[i] - k;
19            ans = Math.min(ans, v + solve(i + 1, d, s - 1, nums, k));
20        }
21        if (d > 0 && s > 0) {
22            int v1 = (nums[i] + 1) / 2;
23            if (v1 >= k) {
24                ans = Math.min(ans, v1 - k + solve(i + 1, d - 1, s - 1, nums, k));
25            }
26            if (nums[i] >= k) {
27                int v2 = nums[i] - k;
28                int v3 = (v2 + 1) / 2;
29                ans = Math.min(ans, v3 + solve(i + 1, d - 1, s - 1, nums, k));
30            }
31        }
32        return dp[i][d][s] = ans;
33    }
34}