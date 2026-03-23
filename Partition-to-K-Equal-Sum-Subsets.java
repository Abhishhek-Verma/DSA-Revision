1class Solution {
2    public boolean canPartitionKSubsets(int[] nums, int k) {
3        int sum = 0;
4        for (int num : nums) sum += num;
5        if (sum % k != 0) return false;
6        int target = sum / k;
7        Arrays.sort(nums);
8        int n = nums.length;
9        if (nums[n - 1] > target) return false;
10        boolean[] visited = new boolean[n];
11        return backtrack(nums, visited, k, 0, 0, target);
12    }
13    private boolean backtrack(int[] nums, boolean[] visited, int k, int start, int currSum, int target) {
14        if (k == 1) return true;
15        if (currSum == target)
16            return backtrack(nums, visited, k - 1, 0, 0, target);
17        for (int i = start; i < nums.length; i++) {
18            if (visited[i] || currSum + nums[i] > target) continue;
19            visited[i] = true;
20            if (backtrack(nums, visited, k, i + 1, currSum + nums[i], target))
21                return true;
22            visited[i] = false;
23        }
24        return false;
25    }
26}