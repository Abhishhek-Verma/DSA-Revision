1class Solution {
2    public int robotSim(int[] commands, int[][] obstacles) {
3        // Store obstacles in a HashSet for O(1) membership test
4        Set<String> obstacleSet = new HashSet<>();
5        for (int[] obs : obstacles) {
6            // Convert each obstacle coordinate to a unique string "x,y"
7            obstacleSet.add(obs[0] + "," + obs[1]);
8        }
9        
10        // Starting position
11        int x = 0, y = 0;
12        // Direction index: 0 = north, 1 = east, 2 = south, 3 = west
13        int dirIdx = 0;
14        // Direction vectors: north, east, south, west
15        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
16        int maxDist = 0;
17        
18        // Process each command
19        for (int cmd : commands) {
20            if (cmd == -2) {
21                // Turn left: decrease index, wrap around with +4
22                dirIdx = (dirIdx - 1 + 4) % 4;
23            } else if (cmd == -1) {
24                // Turn right: increase index
25                dirIdx = (dirIdx + 1) % 4;
26            } else {
27                // Move forward 'cmd' steps, one at a time
28                int dx = dirs[dirIdx][0];
29                int dy = dirs[dirIdx][1];
30                
31                for (int step = 0; step < cmd; step++) {
32                    int nextX = x + dx;
33                    int nextY = y + dy;
34                    
35                    // If the next cell contains an obstacle, stop moving
36                    if (obstacleSet.contains(nextX + "," + nextY)) {
37                        break;
38                    }
39                    
40                    // Otherwise, move and update max distance
41                    x = nextX;
42                    y = nextY;
43                    maxDist = Math.max(maxDist, x*x + y*y);
44                }
45            }
46        }
47        
48        return maxDist;
49    }
50}