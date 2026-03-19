1class Solution {
2    public List<List<String>> partition(String s) {
3        List<List<String>> ans = new ArrayList<>();
4        List<String> ds = new ArrayList<>();
5        check(0, s, ans, ds);
6        return ans;
7    }
8
9    private static void check(int idx, String s, List<List<String>> ans, List<String> ds) {
10        if (idx == s.length()) {
11            ans.add(new ArrayList<>(ds));
12            return;
13        }
14        for (int i = idx; i < s.length(); ++i) {
15            if (isPalindrome(idx, i, s)) {
16                ds.add(s.substring(idx, i + 1));
17                check(i + 1, s, ans, ds);
18                ds.remove(ds.size() - 1);
19            }
20
21        }
22    }
23
24    private static boolean isPalindrome(int i, int j, String s) {
25        while (i <= j) {
26            if (s.charAt(i++) != s.charAt(j--)) {
27                return false;
28            }
29        }
30        return true;
31    }
32}