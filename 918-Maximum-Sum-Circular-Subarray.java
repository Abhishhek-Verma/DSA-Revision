class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int currMax = 0;
        int currMin = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        for (int num : nums) {
            // Kadane for maximum subarray
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            // Kadane for minimum subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
            total += num;
        }
        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }
        int circularSum = total - minSum;
        return Math.max(maxSum, circularSum);
    }
}