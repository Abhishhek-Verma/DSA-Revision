1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        
4        int n = nums.length;
5
6        int rightSum = 0;
7        for (int num : nums) {
8            rightSum += num;
9        }
10
11        int leftSum = 0;
12
13        int[] ans = new int[n];
14
15        for (int i = 0; i < n; i++) {
16
17            rightSum -= nums[i];
18
19            ans[i] = Math.abs(leftSum - rightSum);
20
21            leftSum += nums[i];
22        }
23
24        return ans;
25    }
26}