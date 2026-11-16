    public static int findMaxConsecutiveOnes(int[] nums) {
         int count = 0;     // current streak
        int maxCount = 0;  // maximum streak

        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
