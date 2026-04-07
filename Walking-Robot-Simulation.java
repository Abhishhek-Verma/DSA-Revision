1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        // Store obstacles
4        Set<String> blocked = new HashSet<>();
5        for (int[] o : obstacles) {
6            blocked.add(o[0] + "," + o[1]);
7        }
8
9        // Directions: North, East, South, West
10        int[][] directions = {
11            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
12        };
13
14        int x = 0, y = 0;
15        int dir = 0; // initially facing North
16        int maxDist = 0;
17
18        for (int cmd : commands) {
19            if (cmd == -1) {
20                dir = (dir + 1) % 4; // turn right
21            } 
22            else if (cmd == -2) {
23                dir = (dir + 3) % 4; // turn left
24            } 
25            else {
26                while (cmd-- > 0) {
27                    int nx = x + directions[dir][0];
28                    int ny = y + directions[dir][1];
29
30                    // check obstacle
31                    if (blocked.contains(nx + "," + ny)) break;
32
33                    x = nx;
34                    y = ny;
35
36                    maxDist = Math.max(maxDist, x * x + y * y);
37                }
38            }
39        }
40
41        return maxDist;
42    }
43}