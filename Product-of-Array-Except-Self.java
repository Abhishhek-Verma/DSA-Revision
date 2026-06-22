1class Solution {
2    public int[] productExceptSelf(int[] nums) {
3        int n = nums.length;
4        int[] left = new int[n];
5        int[] right = new int[n];
6        int[] ans = new int[n];
7        left[0] = 1;
8        for (int i = 1; i < n; i++) {
9            left[i] = left[i - 1] * nums[i - 1];
10        }
11        right[n - 1] = 1;
12        for (int i = n - 2; i >= 0; i--) {
13            right[i] = right[i + 1] * nums[i + 1];
14        }
15        for (int i = 0; i < n; i++) {
16            ans[i] = left[i] * right[i];
17        }
18        return ans;
19    }
20}