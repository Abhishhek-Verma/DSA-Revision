1class Solution {
2    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
3        int n = positions.length;
4        Integer[] order = new Integer[n];
5        for (int i = 0; i < n; i++) order[i] = i;
6        Arrays.sort(order, (a, b) -> positions[a] - positions[b]);
7
8        boolean[] dead = new boolean[n];
9        Stack<Integer> st = new Stack<>();
10        for (int i : order) {
11            if (directions.charAt(i) == 'R') {
12                st.push(i);
13            } else {
14                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R') {
15                    int top = st.peek();
16                    if (healths[top] > healths[i]) {
17                        healths[top]--; dead[i] = true; break;
18                    } else if (healths[top] < healths[i]) {
19                        healths[i]--; dead[top] = true; st.pop();
20                    } else {
21                        dead[i] = dead[top] = true; st.pop(); break;
22                    }
23                }
24                if (!dead[i]) st.push(i);
25            }
26        }
27        List<Integer> res = new ArrayList<>();
28        for (int i = 0; i < n; i++)
29            if (!dead[i]) res.add(healths[i]);
30        return res;
31    }
32}