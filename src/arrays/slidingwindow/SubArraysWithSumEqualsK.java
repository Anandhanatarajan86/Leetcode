package arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            int prefixSum = sum + nums[index];
            // check current prefixsum equals k
            if (prefixSum == k) {
                count++;
            }
            // if(prefixSum >=k){
            int deficit = prefixSum - k;
            if (prefixSumCountMap.containsKey(deficit)) {
                count += prefixSumCountMap.get(deficit);
            }
            // }

            // store the current prefix in hashMap
            prefixSumCountMap.put(prefixSum, prefixSumCountMap.getOrDefault(prefixSum, 0) + 1);
            sum = prefixSum;
        }
        return count;
    }
}
