1class Solution {
2    public boolean judgeCircle(String moves) {
3        int c1 = 0; 
4        int c2 = 0;
5        for (char ch : moves.toCharArray()) {
6            if (ch == 'L') c1++;
7            else if (ch == 'R') c1--;
8            else if (ch == 'U') c2++;
9            else if (ch == 'D') c2--;
10        }
11        return c1 == 0 && c2 == 0;
12        
13    }
14}