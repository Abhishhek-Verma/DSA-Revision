1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int n = nums.length, ans = 0;
4
5        for (int i = 0; i <= 30; i++) {
6            int mask = 1 << i, size = 0;
7            int[] arr = new int[n];
8
9            for (int j : nums) {
10                if ((j & mask) == 0)
11                    continue;
12
13                int left = 0, right = size;
14                while (left < right) {
15                    int mid = (left + right) >>> 1;
16                    if (arr[mid] < j)
17                        left = mid + 1;
18                    else
19                        right = mid;
20                }
21
22                arr[left] = j;
23                if (left == size)
24                    size++;
25            }
26
27            ans = Math.max(ans, size);
28        }
29        return ans;
30    }
31}