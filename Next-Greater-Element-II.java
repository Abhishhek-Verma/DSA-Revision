1class Solution {
2    public int[] nextGreaterElements(int[] nums) {
3         int n = nums.length;
4        int[] res = new int[n];
5        Arrays.fill(res, -1);
6        Stack<Integer> st = new Stack<>();
7        for(int i = 2 * n - 1; i >= 0; i--){
8            int num = nums[i % n];
9            while (!st.isEmpty() && st.peek() <= num) {
10                st.pop();
11            }
12            if (i < n) {
13                if (!st.isEmpty()) {
14                    res[i] = st.peek();
15                }
16            }
17            st.push(num);
18        }
19        return res;
20    }
21}