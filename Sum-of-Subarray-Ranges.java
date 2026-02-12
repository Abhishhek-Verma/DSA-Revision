1class Solution {
2    public long subArrayRanges(int[] nums) {
3        long maxSum = getMaxSum(nums);
4        long minSum = getMinSum(nums);
5        return maxSum - minSum;
6    }
7    private long getMinSum(int[] arr) {
8        int n = arr.length;
9        int[] nse = findNSE(arr);
10        int[] psee = findPSEE(arr);
11        long sum = 0;
12        for (int i = 0; i < n; i++) {
13            long left = i - psee[i];
14            long right = nse[i] - i;
15            sum += left * right * arr[i];
16        }
17        return sum;
18    }
19    private int[] findNSE(int[] arr) {
20        int n = arr.length;
21        int[] ans = new int[n];
22        Stack<Integer> st = new Stack<>();
23        for (int i = n - 1; i >= 0; i--) {
24            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
25                st.pop();
26            }
27            ans[i] = st.isEmpty() ? n : st.peek();
28            st.push(i);
29        }
30        return ans;
31    }
32    private int[] findPSEE(int[] arr) {
33        int n = arr.length;
34        int[] ans = new int[n];
35        Stack<Integer> st = new Stack<>();
36        for (int i = 0; i < n; i++) {
37            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
38                st.pop();
39            }
40            ans[i] = st.isEmpty() ? -1 : st.peek();
41            st.push(i);
42        }
43        return ans;
44    }
45    private long getMaxSum(int[] arr) {
46        int n = arr.length;
47        int[] nge = findNGE(arr);
48        int[] pgee = findPGEE(arr);
49        long sum = 0;
50        for (int i = 0; i < n; i++) {
51            long left = i - pgee[i];
52            long right = nge[i] - i;
53            sum += left * right * arr[i];
54        }
55
56        return sum;
57    }
58    private int[] findNGE(int[] arr) {
59        int n = arr.length;
60        int[] ans = new int[n];
61        Stack<Integer> st = new Stack<>();
62        for (int i = n - 1; i >= 0; i--) {
63            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
64                st.pop();
65            }
66            ans[i] = st.isEmpty() ? n : st.peek();
67            st.push(i);
68        }
69        return ans;
70    }
71    private int[] findPGEE(int[] arr) {
72        int n = arr.length;
73        int[] ans = new int[n];
74        Stack<Integer> st = new Stack<>();
75        for (int i = 0; i < n; i++) {
76            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
77                st.pop();
78            }
79            ans[i] = st.isEmpty() ? -1 : st.peek();
80            st.push(i);
81        }
82        return ans;
83    }
84}
85