1class Solution {
2    public boolean rotateString(String s, String goal) {
3        if(s.length()!= goal.length()) return false;
4        String copy = s + s;
5        if (copy.contains(goal)) {
6            return true;
7        } else {
8            return false;
9        }
10    }
11}