class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // Odd total cannot be divided equally
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return solve(nums, 0, target, dp);
    }
    private boolean solve(int[] nums, int i, int target, Boolean[][] dp) {
        // We found the required sum
        if (target == 0) {
            return true;
        }
        // No elements left
        if (i == nums.length || target < 0) {
            return false;
        }
        if (dp[i][target] != null) {
            return dp[i][target];
        }
        // Take nums[i]
        boolean take = solve(nums, i + 1, target - nums[i], dp);
        // Don't take nums[i]
        boolean skip = solve(nums, i + 1, target, dp);
        return dp[i][target] = take || skip; 
    }
}