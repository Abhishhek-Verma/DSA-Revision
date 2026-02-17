1class Solution {
2    public int longestOnes(int[] nums, int k) {
3        int left = 0, zeros = 0;
4        for (int right = 0; right < nums.length; right++) {
5            if (nums[right] == 0) zeros++;
6            if (zeros > k) {
7                if (nums[left] == 0) zeros--;
8                left++;
9            }
10        }
11        return nums.length - left;
12    }
13}