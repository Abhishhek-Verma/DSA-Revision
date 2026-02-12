1class Solution {
2    public List<Long> mergeAdjacent(int[] nums) {
3       Stack<Long> st = new Stack<>();
4
5        for (int x : nums) {
6            long cur = x;
7
8            while (!st.isEmpty() && st.peek() == cur) {
9                cur = st.pop() * 2;
10            }
11
12            st.push(cur);
13        }
14
15        return new ArrayList<>(st);  
16    }
17}