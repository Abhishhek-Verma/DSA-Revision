1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        int sum = 0, count = 0;
4        HashMap<Integer,Integer> map = new HashMap<>();
5        map.put(0,1);
6        for(int x : nums){
7            sum += x % 2;
8            if(map.containsKey(sum-k))
9                count += map.get(sum-k);
10            map.put(sum,map.getOrDefault(sum,0)+1);
11        }
12        return count;
13    }
14}