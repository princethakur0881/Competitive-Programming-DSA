class Solution {
    public int countNonMinimum(int[] nums) {
        if (nums.length == 0) return 0;

        int minimum = nums[0];
        int countMin = 0;

        // Find minimum
        for (int num : nums) {
            if (num < minimum) minimum = num;
        }

        // Count occurrences of minimum
        for (int num : nums) {
            if (num == minimum) countMin++;
        }

        return nums.length - countMin;
        
    }
}
