1class Solution {
2    public boolean canPartitionKSubsets(int[] nums, int k) {
3         int total = 0;
4        for (int num : nums) total += num;
5
6        if (total % k != 0) return false;
7        int target = total / k;
8
9        boolean[] vis = new boolean[nums.length];
10        return backtrack(nums, vis, k, 0, 0, target);
11    }
12
13    private boolean backtrack(int[] nums, boolean[] vis, int k, int start, int sum, int target) {
14        if (k == 1) return true;
15
16        if (sum == target)
17            return backtrack(nums, vis, k - 1, 0, 0, target);
18
19        for (int i = start; i < nums.length; i++) {
20            if (!vis[i] && sum + nums[i] <= target) {
21                vis[i] = true;
22
23                if (backtrack(nums, vis, k, i + 1, sum + nums[i], target))
24                    return true;
25
26                vis[i] = false;
27            }
28        }
29        return false;
30    }
31}