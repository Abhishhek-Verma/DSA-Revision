1class Solution {
2    int[] dp;
3    public int minimumXORSum(int[] nums1, int[] nums2) {
4        int n = nums1.length;
5        dp = new int[1 << n];
6        Arrays.fill(dp, -1);
7        return solve(nums1, nums2, 0, 0);
8    }
9    private int solve(int[] nums1, int[] nums2, int i, int mask) {
10        int n = nums1.length;
11        if (i == n) return 0;
12        if (dp[mask] != -1) return dp[mask];
13
14        int min = Integer.MAX_VALUE;
15        for (int j = 0; j < n; j++) {
16            if ((mask & (1 << j)) == 0) {
17                int xor = nums1[i] ^ nums2[j];
18                int next = solve(nums1, nums2, i + 1, mask | (1 << j));
19                min = Math.min(min, xor + next);
20            }
21        }
22        return dp[mask] = min;
23    }
24}