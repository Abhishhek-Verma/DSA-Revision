1class Solution {
2    public boolean makesquare(int[] nums) {
3        int k =4;
4         int sum = 0;
5        for (int num : nums) sum += num;
6        if (sum % k != 0) return false;
7        int target = sum / k;
8        Arrays.sort(nums);
9        int n = nums.length;
10        if (nums[n - 1] > target) return false;
11        boolean[] visited = new boolean[n];
12        return backtrack(nums, visited, k, 0, 0, target);
13    }
14    private boolean backtrack(int[] nums, boolean[] visited, int k, int start, int currSum, int target) {
15        if (k == 1) return true;
16        if (currSum == target)
17            return backtrack(nums, visited, k - 1, 0, 0, target);
18        for (int i = start; i < nums.length; i++) {
19            if (visited[i] || currSum + nums[i] > target) continue;
20            visited[i] = true;
21            if (backtrack(nums, visited, k, i + 1, currSum + nums[i], target))
22                return true;
23            visited[i] = false;
24        }
25        return false;
26        
27    }
28}