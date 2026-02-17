1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3      List<String> res = new ArrayList<>();
4        for (int h = 0; h < 12; h++) {
5            for (int m = 0; m < 60; m++) {
6                if (Integer.bitCount((h << 6) | m) == turnedOn) {
7                    res.add(h + ":" + (m < 10 ? "0" + m : m));
8                }
9            }
10        }
11        return res;
12    }
13}