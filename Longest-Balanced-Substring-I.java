1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int ans = 0;
5        for (int i = 0; i < n; i++) {
6            HashMap<Character, Integer> mpp = new HashMap<>();
7            int max = 0;
8            for (int j = i; j < n; j++) {
9                char c = s.charAt(j);
10                mpp.put(c, mpp.getOrDefault(c, 0) + 1);
11                max = Math.max(max, mpp.get(c));
12                int len = j - i + 1;
13                int dst = mpp.size();
14                if (max * dst == len) {
15                    ans = Math.max(ans, len);
16                }
17            }
18        }
19        return ans;
20    }
21}