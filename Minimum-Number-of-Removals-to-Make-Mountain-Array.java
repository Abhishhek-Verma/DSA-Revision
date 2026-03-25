1class Solution {
2    public int minimumMountainRemovals(int[] nums) {
3         int n = nums.length;
4        int[] lis = new int[n];
5        int[] lds = new int[n];
6        // LIS from left
7        for (int i = 0; i < n; i++) {
8            lis[i] = 1;
9            for (int j = 0; j < i; j++) {
10                if (nums[j] < nums[i]) {
11                    lis[i] = Math.max(lis[i], lis[j] + 1);
12                }
13            }
14        }
15        // LDS from right
16        for (int i = n - 1; i >= 0; i--) {
17            lds[i] = 1;
18            for (int j = n - 1; j > i; j--) {
19                if (nums[j] < nums[i]) {
20                    lds[i] = Math.max(lds[i], lds[j] + 1);
21                }
22            }
23        }
24        int maxMountain = 0;
25        for (int i = 0; i < n; i++) {
26            if (lis[i] > 1 && lds[i] > 1) {
27                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
28            }
29        }
30        return n - maxMountain; 
31    }
32}