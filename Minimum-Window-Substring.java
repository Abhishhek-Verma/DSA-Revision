1class Solution {
2    public String minWindow(String s, String t) {
3        int n = s.length(), m = t.length();
4        int[] hash = new int[256];
5        for (char c : t.toCharArray())
6            hash[c]++;
7        int left = 0, right = 0, cnt = 0;
8        int sIdx = -1, minL = Integer.MAX_VALUE;
9        while (right < n) {
10            if (hash[s.charAt(right)] > 0)
11                cnt++;
12            hash[s.charAt(right)]--;
13            while (cnt == m) {
14                if (right - left + 1 < minL) {
15                    minL = right - left + 1;
16                    sIdx = left;
17                }
18                hash[s.charAt(left)]++;
19                if (hash[s.charAt(left)] > 0)
20                    cnt--;
21                left++;
22            }
23            right++;
24        }
25        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minL);
26    }
27}