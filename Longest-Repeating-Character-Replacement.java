1class Solution {
2    public int characterReplacement(String s, int k) {
3        int[] freq = new int[26];
4        int left = 0, maxCount = 0, ans = 0;
5        for (int right = 0; right < s.length(); right++) {
6            int idx = s.charAt(right) - 'A';
7            freq[idx]++;
8            maxCount = Math.max(maxCount, freq[idx]);
9            while ((right - left + 1) - maxCount > k) {
10                freq[s.charAt(left) - 'A']--;
11                left++;
12            }
13            ans = Math.max(ans, right - left + 1);
14        }
15        return ans;
16    }
17}