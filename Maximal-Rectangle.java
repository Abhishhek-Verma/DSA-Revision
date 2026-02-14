1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int n = matrix.length, m = matrix[0].length;
4        int[] height = new int[m];
5        int ans = 0;
6        for(int i = 0; i < n; i++){
7            for(int j = 0; j < m; j++){
8                if(matrix[i][j] == '1') height[j]++;
9                else height[j] = 0;
10            }
11            ans = Math.max(ans, largestRectangleArea(height));
12        }
13        return ans;
14    }
15    private static  int largestRectangleArea(int[] arr) {
16        int n = arr.length;
17        int max =0;
18        Stack<Integer> st = new Stack<>();
19        for(int i =0;i<n;i++){
20            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
21                int ele = st.pop();
22                int nse = i;
23                int pse = st.isEmpty()?-1:st.peek();
24                max = Math.max(max, (arr[ele]*(nse-pse-1)));
25            }
26            st.push(i);
27        }
28        while(!st.isEmpty()){
29            int ele = st.pop();
30            int nse = n;
31            int pse = st.isEmpty()?-1:st.peek();
32            max = Math.max(max, (arr[ele]*(nse-pse-1)));
33        }
34        
35        return max;
36    }
37}