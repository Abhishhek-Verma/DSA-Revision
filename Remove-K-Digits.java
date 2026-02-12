1class Solution {
2    public String removeKdigits(String num, int k) {
3        int n = num.length();
4        if (k == n) return "0";
5        Stack<Character> st = new Stack<>();
6        for (char c : num.toCharArray()) {
7            while (!st.isEmpty() && k > 0 && st.peek() > c) {
8                st.pop();
9                k--;
10            }
11            st.push(c);
12        }
13        while (k > 0) {
14            st.pop();
15            k--;
16        }
17        StringBuilder sb = new StringBuilder();
18        while (!st.isEmpty()) sb.append(st.pop());
19        sb.reverse();
20        int i =0;
21        while (i < sb.length() && sb.charAt(i) == '0') i++;
22        String ans = sb.substring(i);
23        return ans.length() == 0 ? "0" : ans;
24
25    }
26}