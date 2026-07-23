class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        // Base cases
        if (n < 3) {
            return n;
        }
        // Find the smallest power of 2 greater than n
        int ans = 1;
        while (ans <= n) {
            ans <<= 1;   // Multiply by 2
        }
        return ans;
    }
}