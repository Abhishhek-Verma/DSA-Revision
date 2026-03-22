1class Solution {
2    public int minRemovals(int[] nums, int target) {
3        int n = nums.length;
4        int m = n/2;
5        int[]l = new int[m];
6        int []r = new int[n-m];
7        for(int i =0;i<m;i++){
8            l[i]= nums[i];
9        }
10        for(int i =m;i<n;i++){
11            r[i-m]= nums[i];
12        }
13        HashMap<Integer, Integer> mpp = new HashMap<>();
14        int ls = l.length;
15        for(int i =0;i<(1<<ls);i++){
16            int xor =0;
17            int cnt =0;
18            for(int j =0;j<ls;j++){
19                if((i&(1<<j))!=0){
20                    xor^=l[j];
21                    cnt++;
22                }
23            }
24            mpp.put(xor,Math.max(mpp.getOrDefault(xor,0),cnt));
25        }
26       int ans =-1;
27        int rs = r.length;
28        for(int i =0;i<(1<<rs);i++){
29            int xor =0;
30            int cnt =0;
31            for(int j =0;j<rs;j++){
32                if((i&(1<<j))!=0){
33                    xor^=r[j];
34                    cnt++;
35                }
36            }
37            int temp = xor^target;
38            if(mpp.containsKey(temp)){
39                ans = Math.max(ans,cnt+mpp.get(temp));
40            }
41        }
42        return ans==-1?-1:n-ans;
43    }
44}