1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3        HashMap<Integer,Integer> mpp = new HashMap<>();
4        for(int x: nums){
5            mpp.put(x,mpp.getOrDefault(x,0)+1);
6        }
7         HashMap<Integer,Integer> mpp2 = new HashMap<>();
8        for(int temp : mpp.values()){
9            mpp2.put(temp,mpp2.getOrDefault(temp,0)+1);
10        }
11        for(int temp : nums){
12            if(mpp2.get(mpp.get(temp))==1) return temp;
13        }
14        return -1;
15    }
16}