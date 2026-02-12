1class Solution {
2    public int[] asteroidCollision(int[] arr) {
3        Stack<Integer> st = new Stack<>();
4        for (int i = 0; i < arr.length; i++) {
5            int curr = arr[i];
6            boolean flag = true;
7            while (flag && curr < 0 && !st.isEmpty() && st.peek() > 0) {
8                if (st.peek() < -curr) {
9                    st.pop();
10                } else if (st.peek() == -curr) {
11                    st.pop();
12                    flag = false;
13                } else {
14                    flag = false;
15                }
16            }
17            if (flag) {
18                st.push(curr);
19            }
20        }
21        int[] ans = new int[st.size()];
22        for (int i = st.size() - 1; i >= 0; i--) {
23            ans[i] = st.pop();
24        }
25        return ans;
26    }
27}