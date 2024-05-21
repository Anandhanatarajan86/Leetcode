package Arrays.Hashing;

import java.util.HashMap;
import java.util.Map;

public class NoOfGoodPairs {
    int  pairs = 0;
    Map<Integer,Integer> frequencyMap = new HashMap<>();
    public int countKDifference(int[] nums, int k) {
        for(int element : nums){

            int target = (element - k);
            int target2 = (element+k);
            // if(element )
            if(frequencyMap.containsKey(target)){
                pairs += frequencyMap.get(target);
            }
            if(frequencyMap.containsKey(target2)){
                pairs += frequencyMap.get(target2);
            }
            frequencyMap.put(element,frequencyMap.getOrDefault(element,0)+1);
        }
        return pairs;
    }
}
