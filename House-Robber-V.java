1class Solution {
2    public long rob(int[] nums, int[] colors) {
3      int n = nums.length;
4        long tk = nums[0];
5        long ntk =0;
6        for(int i =1;i<n;i++){
7            long tk1;
8            if(colors[i]==colors[i-1]) tk1 = ntk+nums[i];
9            else tk1 = Math.max(ntk,tk)+nums[i];
10            long ntk1 = Math.max(ntk,tk);
11            tk = tk1;
12            ntk = ntk1;
13        }
14        return Math.max(tk,ntk);
15    }
16}