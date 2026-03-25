1//main intuition ye h ki mai jis index pe hu 
2//us index pr usse phle kitne inc and kitne dec element hai
3//then try to maximize it,tabhi minimum removal of elements hoga 
4
5class Solution {
6    public int minimumMountainRemovals(int[] nums) {
7         int n = nums.length;
8        int[] lis = new int[n];
9        int[] lds = new int[n];
10        // LIS from left
11        for (int i = 0; i < n; i++) {
12            lis[i] = 1;
13            for (int j = 0; j < i; j++) {
14                if (nums[j] < nums[i]) {
15                    lis[i] = Math.max(lis[i], lis[j] + 1);
16                }
17            }
18        }
19        // LDS from right
20        for (int i = n - 1; i >= 0; i--) {
21            lds[i] = 1;
22            for (int j = n - 1; j > i; j--) {
23                if (nums[j] < nums[i]) {
24                    lds[i] = Math.max(lds[i], lds[j] + 1);
25                }
26            }
27        }
28        int maxMountain = 0;
29        for (int i = 0; i < n; i++) {
30            if (lis[i] > 1 && lds[i] > 1) {
31                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
32            }
33        }
34        return n - maxMountain; 
35    }
36}