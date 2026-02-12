1class Solution {
2    public int sumSubarrayMins(int[] arr) {
3        int n = arr.length;
4        int[] nse = findNSE(arr);
5        int[] psee = findPSEE(arr);
6        int mod = (int)1e9 + 7;
7        int sum = 0;
8        for (int i = 0; i < n; i++) {
9            int left = i - psee[i];
10            int right = nse[i] - i;
11            long freq = left * right * 1L;
12            int val = (int)((freq * arr[i]) % mod);
13            sum = (sum + val) % mod;
14        }
15        return sum;
16    }
17    private int[] findNSE(int[] arr) {
18        int n = arr.length;
19        int[] ans = new int[n];
20        Stack<Integer> st = new Stack<>();
21        for (int i = n - 1; i >= 0; i--) {
22            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
23                st.pop();
24            }
25            ans[i] = !st.isEmpty() ? st.peek() : n;
26            st.push(i);
27        }
28        return ans;
29    }
30    private int[] findPSEE(int[] arr) {
31        int n = arr.length;
32        int[] ans = new int[n];
33        Stack<Integer> st = new Stack<>();
34        for (int i = 0; i < n; i++) {
35            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
36                st.pop();
37            }
38            ans[i] = !st.isEmpty() ? st.peek() : -1;
39            st.push(i);
40        }
41        return ans;
42    }
43}