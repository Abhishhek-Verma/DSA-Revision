1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        Arrays.sort(nums);
4        int n= nums.length;
5        List<List<Integer>> ans = new ArrayList <>();
6        for(int i=0; i<n-2;i++){
7            if(i>0 && nums[i]== nums[i-1]) continue;
8            int j = i+1;
9            int k = n-1;
10            while(j<k){
11                int sum = nums[i] + nums[j] + nums[k];
12                if(sum<0) {
13                    j++;
14                }
15                else if(sum>0){
16                         k--;
17                }
18                else{
19                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
20                    j++;
21                    k--;
22                while(j<k && nums[j]==nums[j-1]) j++;
23        
24                while(j<k && nums[k]== nums[k+1]) k--;
25                }
26
27            }
28        }
29            return ans;
30    }       
31}
32