1class Solution {
2    public int maxDistance(int[] stalls, int cows) {
3         Arrays.sort(stalls);
4        int low = 1;
5        int high = stalls[stalls.length - 1] - stalls[0];
6        int ans = 0;
7        while (low <= high) {
8            int mid = low + (high - low) / 2;
9            if (canPlace(stalls, cows, mid)) {
10                ans = mid;
11                low = mid + 1;
12            }
13            else {
14                high = mid - 1;
15            }
16        }
17        return ans;
18    }
19     public boolean canPlace(int[] stalls, int cows, int d) {
20        int count = 1;
21        int lastPos = stalls[0];
22        for (int i = 1; i < stalls.length; i++) {
23            if (stalls[i] - lastPos >= d) {
24                count++;
25                lastPos = stalls[i];
26            }
27            if (count >= cows) return true;
28        }
29        return false;
30    }
31}