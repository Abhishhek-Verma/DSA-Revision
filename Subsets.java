1class Solution {
2    public List<List<Integer>> subsets(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        int n = nums.length;
5        int total = 1 << n;
6        for(int mask = 0; mask < total; mask++){
7            List<Integer> temp = new ArrayList<>();
8            for(int i = 0; i < n; i++){
9                if((mask & (1 << i)) != 0){
10                    temp.add(nums[i]);
11                }
12            }
13            
14            res.add(temp);
15        }
16        
17        return res;
18    }
19}
20