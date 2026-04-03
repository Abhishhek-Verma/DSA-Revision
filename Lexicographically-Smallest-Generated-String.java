1class Solution {
2    public String generateString(String str1, String str2) {
3        int n = str1.length();
4        int m = str2.length();
5        char[] s = new char[n + m - 1];
6        int[] fixed = new int[n + m - 1];
7
8        for (int i = 0; i < s.length; i++) {
9            s[i] = 'a';
10        }
11        for (int i = 0; i < n; i++) {
12            if (str1.charAt(i) == 'T') {
13                for (int j = i; j < i + m; j++) {
14                    if (fixed[j] == 1 && s[j] != str2.charAt(j - i)) {
15                        return "";
16                    } else {
17                        s[j] = str2.charAt(j - i);
18                        fixed[j] = 1;
19                    }
20                }
21            }
22        }
23
24        for (int i = 0; i < n; i++) {
25            if (str1.charAt(i) == 'F') {
26                boolean flag = false;
27                int idx = -1;
28                for (int j = i + m - 1; j >= i; j--) {
29                    if (str2.charAt(j - i) != s[j]) {
30                        flag = true;
31                    }
32                    if (idx == -1 && fixed[j] == 0) {
33                        idx = j;
34                    }
35                }
36                if (flag) {
37                    continue;
38                } else if (idx != -1) {
39                    s[idx] = 'b';
40                } else {
41                    return "";
42                }
43            }
44        }
45        return new String(s);
46    }
47}