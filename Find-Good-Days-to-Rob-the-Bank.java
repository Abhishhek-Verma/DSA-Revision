1class Solution {
2    public List<Integer> goodDaysToRobBank(int[] arr, int k) {
3        int n = arr.length;
4        int[] dec = new int[n];
5        int[] inc = new int[n];
6        List<Integer> ans = new ArrayList<>();
7        for(int i = 1; i < n; i++){
8            if(arr[i]<=arr[i-1]){
9                dec[i]=dec[i-1]+1;
10            } else {
11                dec[i]=0;
12            }
13        }
14        for(int i = n-2; i >= 0; i--){
15            if(arr[i] <= arr[i+1]){
16                inc[i] = inc[i+1] + 1;
17            } else {
18                inc[i]=0;
19            }
20        }
21        for(int i = k; i < n-k; i++){
22            if(dec[i]>=k && inc[i]>=k){
23                ans.add(i);
24            }
25        }
26        return ans;
27    }
28}