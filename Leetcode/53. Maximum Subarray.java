class Solution {
    public int maxSubArray(int[] nums) {
        //find the subarray  with the largest sum
        // Return 0 if the input array is empty
        if (nums.length == 0) {
            return 0;
        }

        // Initialize variables to track the maximum sum and the current sum
        int maxSum = nums[0];
        int currentSum = 0;
        
        // Iterate through each element in the array
        for (int num : nums) {
            // Update the current sum by adding the current element, unless the current sum is negative, in which case we reset it to the current element
            currentSum = Math.max(currentSum + num, num);
            // Update the maximum sum if the current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // Return the maximum sum
        return maxSum;
    }
}