1class Solution {
2    public int minCost(int[] nums1, int[] nums2) {
3        Map<Integer,Integer> c1 = new HashMap<>();
4        Map<Integer,Integer> c2 = new HashMap<>();
5        Map<Integer,Integer> total = new HashMap<>();
6        for(int x:nums1){
7            c1.put(x,c1.getOrDefault(x,0)+1);
8            total.put(x,total.getOrDefault(x,0)+1);
9        }
10        for(int x:nums2){
11            c2.put(x,c2.getOrDefault(x,0)+1);
12            total.put(x,total.getOrDefault(x,0)+1);
13        }
14        for(int v:total.values()){
15            if(v%2==1) return -1;
16        }
17        int cost=0;
18        for(int key:total.keySet()){
19            int target = total.get(key)/2;
20            int a = c1.getOrDefault(key,0);
21
22            if(a>target) cost += (a-target);
23        }
24        return cost;
25    }
26}