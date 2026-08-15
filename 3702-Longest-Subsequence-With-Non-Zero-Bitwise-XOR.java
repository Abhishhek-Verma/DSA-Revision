class Solution {
    public int longestSubsequence(int[] nums) {
         int n = nums.length;
        int x=0;
        boolean t= true;
        for(int c : nums){
            x^=c;
            if(c!=0) t = false;
        }
        if(t) return 0;
        if(x!=0) return n;
        return n-1;
    }
}