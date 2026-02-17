1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int n = s.length();
4        int max = 0;
5        Set<Character> charset = new HashSet<>(); 
6        int left = 0;
7
8        for (int right = 0; right < n; right++) {
9                while(charset.contains(s.charAt(right))) {
10                    charset.remove(s.charAt(left));
11                    left++;
12                }
13                charset.add(s.charAt(right));
14                max = Math.max(right-left+1,max);
15        }
16
17        return max;
18    }
19}
20