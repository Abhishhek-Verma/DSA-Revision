1class Solution {
2    public int minimumDeletions(String s) {
3        int res = 0, b = 0;
4        for (int i = 0; i < s.length(); i++) {
5            char c = s.charAt(i);
6            if (c == 'b')
7                b++;
8            else if (b > 0) {
9                res++;
10                b--;
11            }
12        }
13
14        return res;
15    }
16}
17