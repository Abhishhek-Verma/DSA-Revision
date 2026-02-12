1class Solution {
2    public int trap(int[] height) {
3        int n= height.length;
4        int leftmax[]= new int [n];
5        leftmax[0]= height[0];
6        for(int i=1; i<n; i++){
7            leftmax[i]= Math.max(height[i], leftmax[i-1]);
8        }
9        int rightmax[]= new int [n];
10        rightmax[n-1]= height[n-1];
11        for(int i=n-2; i>=0; i--){
12            rightmax[i]= Math.max(height[i], rightmax[i+1]);
13
14        }
15        int trappedwater=0;
16        for(int i=0;i<n; i++){
17            int waterlevel = Math.min(leftmax[i], rightmax[i]);
18            trappedwater+=waterlevel- height[i];
19        }
20        return trappedwater;
21    }
22}