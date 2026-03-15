1class Solution {
2    public int firstUniqueEven(int[] nums) {
3        HashMap<Integer,Integer> mpp = new HashMap<>();
4        for(int x: nums){
5            mpp.put(x,mpp.getOrDefault(x,0)+1);
6        }
7        for(int x : nums){
8            if(x % 2 == 0 && mpp.get(x) == 1){
9                return x;
10            }
11        }
12        return -1;
13    }
14}