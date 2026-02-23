1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> lst = new ArrayList<>();
4        cnt(lst, "", 0, 0, n);
5        return lst;
6    }
7    private static void cnt(List<String> lst, String s, int o, int c, int n) {
8        if (o == n && c == n) {
9            lst.add(s);
10            return;
11        }
12        if (o < n) {
13            cnt(lst, s + "(", o + 1, c, n);
14        }
15        if (c < o) {
16            cnt(lst, s + ")", o, c + 1, n);
17        }
18    }
19}