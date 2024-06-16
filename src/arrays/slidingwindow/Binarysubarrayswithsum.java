package arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public  class Binarysubarrayswithsum {
        int[] prefixSumArray;
        Map<Integer,Integer> prefixSumFrequencyMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        public int numSubarraysWithSum(int[] nums, int goal) {
            for(int index = 0; index < nums.length; index++){
                int currPrefixSum =  sum + nums[index];

                //check currPrefixSum equals goal
                if(currPrefixSum == goal){
                    count++;
                }
                int previousPrefixSum =  currPrefixSum -goal;
                if(prefixSumFrequencyMap.containsKey(previousPrefixSum)){
                    count+= prefixSumFrequencyMap.get(previousPrefixSum);
                }
                prefixSumFrequencyMap.put(currPrefixSum,prefixSumFrequencyMap.getOrDefault(currPrefixSum,0)+1);
                sum =  currPrefixSum;
            }
            return    count;
        }
    }

