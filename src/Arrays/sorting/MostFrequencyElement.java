package Arrays.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MostFrequencyElement {
    Map<Integer,Integer> frequencyMap = new HashMap<>();
    Integer maxElement = null;
    int maxFrequency = 0;
    public int MostFrequent(int[] arr) {
        //Write your code here
        for(int element: arr){
            frequencyMap.put(element,frequencyMap.getOrDefault(element,0)+1);
            maxFrequency = Math.max(maxFrequency,frequencyMap.get(element));
            if(maxFrequency==frequencyMap.get(element)){
                maxElement = (maxElement==null)?element:(element<maxElement)?element:maxElement;
            }
        }
      //  System.out.println(maxElement);
return maxElement;

    }
    public  static void main(String[] args){
        MostFrequencyElement mostFrequencyElement = new MostFrequencyElement();
        mostFrequencyElement.MostFrequent(new int[]{5,5,5,6,6,6,7,7,8});
    }
}
