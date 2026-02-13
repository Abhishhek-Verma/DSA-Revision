1class Solution {
2    public int largestRectangleArea(int[] arr) {
3        int n = arr.length;
4        int max =0;
5        Stack<Integer> st = new Stack<>();
6        for(int i =0;i<n;i++){
7            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
8                int ele = st.pop();
9                int nse = i;
10                int pse = st.isEmpty()?-1:st.peek();
11                max = Math.max(max, (arr[ele]*(nse-pse-1)));
12            }
13            st.push(i);
14        }
15        while(!st.isEmpty()){
16            int ele = st.pop();
17            int nse = n;
18            int pse = st.isEmpty()?-1:st.peek();
19            max = Math.max(max, (arr[ele]*(nse-pse-1)));
20        }
21        
22        return max;
23    }
24}