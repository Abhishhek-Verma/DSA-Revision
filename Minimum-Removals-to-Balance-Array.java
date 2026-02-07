1class Solution {
2    public int minRemoval(int[] nums, int k) {
3        Arrays.sort(nums);
4        int i = 0;
5        int max = 0;
6
7        for (int j = 0; j < nums.length; j++) {
8            while ((long) nums[j] > (long) nums[i] * k) {
9                i++;
10            }
11            max= Math.max(max, j - i + 1);
12        }
13
14        return nums.length - max;
15    }
16}