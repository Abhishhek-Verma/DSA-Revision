1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] freq = new int[52];
4        for (int i = 0; i < s1.length(); i++) {
5            int off = (i & 1) * 26;
6            freq[s1.charAt(i) - 'a' + off]++;
7            freq[s2.charAt(i) - 'a' + off]--;
8        }
9        for (int i = 0; i < 52; i++)
10            if (freq[i] != 0) return false;
11        return true;
12    }
13}