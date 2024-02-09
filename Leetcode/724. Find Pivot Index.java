class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int prevSum = 0;
        for (int value: nums) {
            sum+=value;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum == (2 * prevSum) + nums[i]) {
                return i;
            }
            prevSum += nums[i];
        }
        return -1;
    }
}