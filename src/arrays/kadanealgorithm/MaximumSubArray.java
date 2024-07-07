package arrays.kadanealgorithm;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;
        int historicLowPrefixSum = 0;
        int sum = 0;

        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            maxSubArray = Math.max(maxSubArray, sum);//with current index as endIndex and startIndex as 0
            maxSubArray = Math.max(maxSubArray, sum - historicLowPrefixSum);//startIndex can be any
            historicLowPrefixSum = Math.min(historicLowPrefixSum, sum);
        }

        // Handle case when the whole array is the max subarray
        maxSubArray = Math.max(maxSubArray, sum);

        return maxSubArray;
    }
}

