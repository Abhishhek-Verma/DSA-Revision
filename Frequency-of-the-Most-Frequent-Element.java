1class Solution {
2    public int maxFrequency(int[] nums, int k) {
3        Arrays.sort(nums);
4        long sum = 0;
5        int l = 0;
6        int ans = 1;
7        for (int i = 0; i < nums.length; i++) {
8            sum += nums[i];
9            while ((long) nums[i] * (i - l + 1) - sum > k) {
10                sum -= nums[l];
11                l++;
12            }
13            ans = Math.max(ans, i - l + 1);
14        }
15        return ans;
16    }
17}